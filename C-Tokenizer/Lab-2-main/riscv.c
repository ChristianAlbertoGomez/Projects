#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h> // malloc & free
#include <stdint.h> // use guaranteed 64-bit integers
#include "tokenizer.h" // Create header file and reference that
#include "memory.h" // built-in functions to read and write to a specific file

int32_t* reg; // Array of 32 32-bit registers

char* file_name = "mem.txt";

void init_regs();
bool interpret(char* instr);
void write_read_demo();
long int converterAtoi(char* command); //aqui
int findCommand(char* command);
int compareCommand(char* command,char* inputUser);
int offsetValue(char* string);
char* get_baseToken(char* instr);
int justCheck(char* command);

/**
 * Initialize register array for usage.
 * Malloc space for each 32-bit register then initializes each register to 0.
 * Do not alter this function!
 */
void init_regs(){
	int reg_amount = 32;
	reg = malloc(reg_amount * sizeof(int32_t)); // 32 * 4 bytes
	for(int i = 0; i < 32; i++)
		reg[i] = i;
}

/**
 * Prints all 32 registers in column-format
 */
void print_regs(){
    int col_size = 10;
    for(int i = 0; i < 8; i++){
        printf("X%02i:%.*lld", i, col_size, (long long int) reg[i]);
        printf(" X%02i:%.*lld", i+8, col_size, (long long int) reg[i+8]);
        printf(" X%02i:%.*lld", i+16, col_size, (long long int) reg[i+16]);
        printf(" X%02i:%.*lld\n", i+24, col_size, (long long int) reg[i+24]);
    }
}

/**
 * Fill out this function and use it to read interpret user input to execute RV64 instructions.
 * You may expect that a single, properly formatted RISC-V instruction string will be passed
 * as a parameter to this function.
 */
bool interpret(char* instr){

  /*
   Here we set the delimeters we will use for our code.
  */
  char delimeters[] = {"ADD,X ADDI"};
  char delimetersTwo[] = {"SW,LW () X"};
  char baseDelim[] = {"SW,LW"};

  /*
    Here I will move our instr into a char array. This because I will use
    strtok() function to display stuff.
    why strtok()? My tokenizer is giving me a lot of problems.
  */
  char command[strlength(instr)];

  int i;
  for(i=0;i<strlength(instr);i++){
    command[i] = instr[i];
  }

  /*
    Here I used "token" to tokenize our command according to our delimeters.
  */
  char* token = strtok(command,delimeters);

  /*
   Formulas:
   ADD -> ADD,rd,rs1,rs2.
   ADDI -> ADDI,rd,rs1,rs2.
   LW -> LW,rd,Offset(base).
   SW -> SW,rd,Offset(base).
  */
  long int rs1; //Declare rs1
  long int rs2; //Declare rs2
  long int rd;  //Declare rd
  long int base; //Declare base
  long int address; //Declare address

  /*
    The next if-statements checks which command we will be using.
    Exampel: if the findCommand() == 1 then we will use ADD.
    -Values:
     ADD->1
     ADDI->2
     LW->3
     SW->4
  */
  if(findCommand(instr)==1){

     rd = converterAtoi(token);

     token = strtok(NULL,delimeters);//Get rs1 token from the string.
     rs1 = converterAtoi(token); //atoi that token.

     token = strtok(NULL,delimeters);//Get rs2 token from the string.

     rs2 = converterAtoi(token); //atoi that token.

     long int total = rs1+rs2; //add rs1 and rs2.

      reg[rd] = total; //store the total in the register[rd].

     //just checking if the sum is correct.
     printf("Total of sum is:%ld \n",total);

     return true;

   }else if(findCommand(instr)==2){

     rd = converterAtoi(token);

     token = strtok(NULL,delimeters);//Get rs1
     rs1 = converterAtoi(token); //Atoi rs1

     token = strtok(NULL,delimeters);//Get rs2
     rs2 = converterAtoi(token);//Atoi rs2

     long int total = rs1+rs2;//sum rs1 and rs2
     reg[rd] =  total;//store the total in reg[rd]

     printf("Total of sum is:%ld \n",total);

     return true;

   }else if(findCommand(instr)==3){
     printf("This is LW instructions:  \n");
     //I'll explain how this works with an example.
     //Example: LW,X2,6(X7).
     //Here we are taking X2 with out the X, then it is 2.
     char* lwToken = strtok(instr,delimetersTwo);

     rd = converterAtoi(lwToken);//We atoi the string/token = 2.
     printf("%d \n",rd); //Testing

     lwToken = strtok(NULL,delimetersTwo);//Here we are taking 6.
     long int offset = atoi(lwToken)*4; //offset = 6*4 = 24.
     printf("%s:%ld \n",lwToken,offset);//Testing

     lwToken = strtok(NULL,delimetersTwo);//Here we are taking 7.
     base = atoi(lwToken);//Atoi string/token = 7.
     printf("%s:%ld \n",lwToken,base);//Testing

     address = base+offset; //We sum them to get the address.
     reg[rd] = read_address(address,file_name);//Now we are ready to LW.

     return true;

   }else if(findCommand(instr)==4){
     printf("This is SW instructions \n");

    //Here I'll explain how this works using an example.
    //Example: SW,X5,8(X6)

     //Here we are taking string/token = 5.
     char* swToken = strtok(instr,delimetersTwo);

     rd = converterAtoi(swToken);//atoi string/token 5.
     printf("%d \n",rd);//Testing

     swToken = strtok(NULL,delimetersTwo);//Taking string/token =  8.
     long int offset = atoi(swToken)*4;//offset = 8*4 = 32.
     printf("%s:%ld \n",swToken,offset);//Testing

     swToken = strtok(NULL,delimetersTwo);//Taking string/token = 6.
     base = atoi(swToken);//Atoi string/token = 6.
     printf("%s:%ld \n",swToken,base);

     address = base+offset;//Address = 6+32 = 38.
     write_address(rd,address,file_name);//Store the word.

     return true;

   }else{
     //In case that the user enters an incorrect command.
     printf("Nothing \n");
     return false;
   }
}

//FIX THIS METHOD
/*
  The main purpose of this method was to geth the base token from SW or LW.
  I didn't used this method because I decided to use strtok().
  My tokenize was giving me a lot of problems trying to do LW and SW.
*/
char* get_baseToken(char* instr){
  char baseDelim[] = {"SW,LW"};
  char command[strlength(instr)];

  int i;
  for(i=0;i<strlength(instr);i++){
    command[i] = instr[i];
  }

  char* baseToken = strtok(command,baseDelim);

  baseToken = strtok(NULL,baseDelim);

  return baseToken;
}

/*
  Method that will inform if the token has a '-' symbol.
  If yes, then the function will notify we are dealing with negative
  number. If not, then all good with the process.
*/
int justCheck(char* command){
  if(command[0]=='-'){
    return 1;
  }else{
    return 0;
  }
}

/*
  This method will help us to atoi even negative numbers.
  NOTE: I tried all posible solutions to convert the number
        into a negative number in case where command has '-'.
        But nothing worked.I used atol() to check if my token
        was the one with problems but it isn't.
*/
long int converterAtoi(char* command){
  long int number = atoi(command);
  long int zero = 0;
  if(justCheck(command)==1){
     return zero-number;
  }else{
     return number;
  }
}

/*
  This method will tell us which instruction we will use according to the
  user's input.
*/
int findCommand(char* command){

     //Here I used my tokenizer from Lab 1. This works really well.
     char delimeter = ',';
     char** temp_tokenizer = tokenize(command,delimeter);

     /*
     ADD = 1
     ADDI = 2
     LW = 3
     SW = 4
     */
     while(*temp_tokenizer){
      if(compareCommand("ADD",*temp_tokenizer)==1){
          return 1;
       }//1
      if(compareCommand("ADDI",*temp_tokenizer)==1){
          return 2;
       }//2
      if(compareCommand("LW",*temp_tokenizer)==1){
          return 3;
       }//3
      if(compareCommand("SW",*temp_tokenizer)==1){
          return 4;
       }//4
      else{
          return 0;
       }//else
     }
}

/*
  This method works to check if the input and the instruction from
  our table are equals.
  Example:
  Table has = ADD,ADDI,LW,SW
  User input = ADDI
  Then the method will check if the user input matches with anything
  from our table.
*/
int compareCommand(char* command,char* inputUser){
   int flag=1;

   //Here we just transverse the strings until one of the strings
   //is '\0'
   while(*command!='\0'&&*inputUser!='\0'){
      if(*command!=*inputUser){
        flag=0;
      }
     command++;
     inputUser++;
   }

   if(flag==1)
    return 1;
   else
    return 0;
}

/*
  The main purpose of this method was to geth the offset  token from SW or LW.
  I didn't used this method because I decided to use strtok().
  My tokenize was giving me a lot of problems trying to do LW and SW.
*/

int offsetValue(char* string){
   int length = strlength(string);
   int i=0;
   int j;
   int immediateValue;

   while(string[i] != '('){
     i++;
   }

   char immediate[length-i];

   for(j=0;j<(length-i);j++){
     immediate[j] = string[j];
   }
    immediateValue = atoi(immediate);
    return immediateValue;
}

/**
 * Simple demo program to show the usage of read_address() and write_address() found in memory.c
 * Before and after running this program, look at mem.txt to see how the values change.
 * Feel free to change "data_to_write" and "address" variables to see how these affect mem.txt
 * Use 0x before an int in C to hardcode it as text, but you may enter base 10 as you see fit.
 */
void write_read_demo(){
	int32_t data_to_write = 0xFFF; // equal to 4095
	int32_t address = 0x98; // equal to 152
	char* mem_file = "mem.txt";

	// Write 4095 (or "0000000 00000FFF") in the 20th address (address 152 == 0x98)
	int32_t write = write_address(data_to_write, address, mem_file);
	if(write == (int32_t) NULL)
		printf("ERROR: Unsucessful write to address %0X\n", 0x40);
	int32_t read = read_address(address, mem_file);

	printf("Read address %lu (0x%lX): %lu (0x%lX)\n", address, address, read, read); // %lu -> format as an long-unsigned
}

/**
 * Your code goes in the main
 *
 */
int main(){
	// Do not write any code between init_regs
	init_regs(); // DO NOT REMOVE THIS LINE

	// Below is a sample program to a write-read. Overwrite this with your own code.
	write_read_demo();

        print_regs();

    //TA'S CODE
    // Below is a sample program to a write-read. Overwrite this with your own code.
    //write_read_demo();

    printf(" RV32 Interpreter.\nType RV32 instructions. Use upper-case letters and space as a delimiter.\nEnter 'EOF' character to end program\n");


    char* instruction = malloc(1000 * sizeof(char));
    bool is_null = false;
    // fgets() returns null if EOF is reached.
    is_null = fgets(instruction, 1000, stdin) == NULL;
    while(!is_null){
        interpret(instruction);
        printf("\n");
        print_regs();
        printf("\n");

        is_null = fgets(instruction, 1000, stdin) == NULL;
    }

    printf("Good bye!\n");

      /*

        Here I was testing my code.

        int maxLength = 100;
        char command[maxLength];
        char delimeter;

        printf("Please enter a command: \n");
        fgets(command,maxLength,stdin);

        printf("Please enter your delimeter: \n");
        delimeter = getchar();

        char** temp_tokenize =  tokenize(command,delimeter);
        print_all_tokens(temp_tokenize);

        interpret(command);

          */
	return 0;
}
