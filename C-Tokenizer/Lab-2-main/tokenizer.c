#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX_LENGTH 100

bool delim_character(char c,char delim);
bool non_delim_character(char c, char delim);
int strlength(char *words);
char* word_start(char *str,char delimeter);
char* end_word(char *str,char delimeter);
int count_tokens(char* str,char delim);
char *copy_str(char *inStr, short len, char delim);
char** tokenize(char* str,char delim);
void print_all_tokens(char** tokens);

/*
  This method will help us to know the length of string words.
*/
int strlength(char *words){
  int i;
  int len;
  for(i=0;words[i]!='\0';i++){
  len = i;
 }
  return len;
}
/*
  This method will help us to know the length of a token.
*/
int length(char* str,char delim) 
{
  char* start = word_start(str,delim);
  char* end = end_word(str,delim);
  int len = end-start;
  return len;
}


/* Return true (non-zero) if c is the delimiter character
   previously chosen by the user.
   Zero terminators are not printable (therefore false) */
bool delim_character(char c, char delim)
{
  char zeroTerminator = '\0';
  if(c==delim){
     return true;
   }
  if(c==zeroTerminator){
     return false;
   }
   else{
    return false;
   }
}

/* Return true (non-zero) if c is a non-delimiter
   character.
   Zero terminators are not printable (therefore false) */
bool non_delim_character(char c, char delim)
{
  char zeroTerminator = '\0';
  if(c!=delim){
     return true;
   }
  if(c==zeroTerminator){
     return false;
   }else{
     return false;
   }
}

/* Returns a pointer to the first character of the next
   word starting with a non-delimiter character. Return a zero pointer if
   str does not contain any words.*/
char *word_start(char* str,char delim)
{
  char *temp_str = str; //copy of str.
  int len = strlength(temp_str); //length of str.
  int i = 0; //i will be used for the while loop.
  bool target;//variable to store return value of delim_character()

  //if str length is 0 then we return null.
  if(len == 0){
    return NULL;
  }

  while(*(temp_str+i)){
   target = non_delim_character(*(temp_str+i),delim);
    if(target == true){
      return temp_str+i;
    }
    i++;
  }
   return temp_str+i;

}

/* Returns a pointer to the first delimiter character of the zero
   terminated string*/
char *end_word(char* str,char delim)
{
  char *temp_str = str; //copy of str.
  int len = strlength(temp_str); //length of str.
  int i = 0; //i will be used for the while loop.
  bool target;//variable to store return value of delim_character()

  //if str length is 0 then we return null.
  if(len == 0){
    return NULL;
  }

  while(*(temp_str+i)){
   target = delim_character(*(temp_str+i),delim);
    if(target == true){
      return temp_str+i;
    }
    i++;
  }
   return temp_str+i;
}

/* Counts the number of words or tokens*/
int count_tokens(char* str,char delim)
{
  int counter = 0; //works as counter for each word.
  int i = 0; //works for our loop.
  char* temp_str = str; //copy of char* str
  bool target; //this will help us to know the return value of non-delim

  //Now we use the temp variable to get the start_word result;
  temp_str = word_start(str,delim);
  //Now we apply a while loop to start counting the tokens.
  while(*temp_str){
     target = non_delim_character(*(temp_str+i),delim);
     if(target == true){
       counter++;
     }
     temp_str=end_word(temp_str,delim);
     temp_str=word_start(temp_str,delim);
   }
  return counter;
}

/* Returns a freshly allocated new zero-terminated string
   containing <len> chars from <inStr> */
char *copy_str(char *inStr, short len, char delim)
{
   //Declare the length of inStr.
   short temp_len = len;

  //Declare a temp copy string for inStr.
  //We use len+1 to take in count the '\0' at the end of a string.
  //To copy correctly we need malloc. Sizeof will tell us the size
  // capacity of a char*.
   char* temp_inStr = malloc((temp_len+1)*sizeof(char*));

   //Next thing is copy each index of inStr into the temp_inStr.
   int i; //for loop
   for(i=0;i<temp_len;i++){
    temp_inStr[i] = inStr[i];
  }
   temp_inStr[i] = '\0'; //We have to add the \0 at the end of the copy.

   return temp_inStr; //Now we return the copy!
}

/* Returns a freshly allocated zero-terminated vector of freshly allocated
   delimiter-separated tokens from zero-terminated str.
   For example, tokenize("hello world string"), with a character delimiter
   of a space " " would result in:
     tokens[0] = "hello"
     tokens[1] = "world"
     tokens[2] = "string"
     tokens[3] = 0
*/
char** tokenize(char* str, char delim)
{
  /*
    For this method we have to do 2 principal steps:
    1) Declare a char** variable using malloc.
    2) Declare a variable to know how many words do we have in the String.
    2.2) We have to avoid delimeter. Then we use count_tokens method as size.

    Edwin helped me to undestand much better what char** does.
  */

   int total_tokens = count_tokens(str,delim);
   char** temp_tokenizer = malloc((total_tokens+1)*sizeof(char*));
   int i; //i is used in our for loop.
   int len; //len will be used to know the str size of the word.

   /*First we use a for loop we a range of total tokens we have in our str*/
   for(i=0;i<total_tokens;i++){
     //We use word_start to know when our word start.
     str = word_start(str,delim);
     //length method will tell us how long is the first token.
     len = length(str,delim);
     //We store each copy token inside of our tokenizer.
     temp_tokenizer[i] = copy_str(str,len,delim);
     //This sentences means that we are going to move to the next token.
     str = end_word(str,delim);
   }
   //At the end we must input '\0'.
   temp_tokenizer[i]='\0';

   return temp_tokenizer;
}

void print_all_tokens(char** tokens)
{
  int counter = 0;
  char** temp_tokens = tokens;

  while(*temp_tokens){
    printf("Token[%d]: %s \n",counter,*temp_tokens);
    counter++;
    temp_tokens++;
  }
}
