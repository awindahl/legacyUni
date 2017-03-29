#include <stdio.h>

char* text1 = "This is a string.";
char* text2 = "Yet another thing.";

int list1[80];  // allocates 80 uninitialized bytes for 20 elements in the integer array
int list2[80];  //  --- | | ---
int count = 0;  // single integer variable with value 0

void copycodes (char *text, int *list, int *count){
    int tempText;
    int i = 0;
    int j = 0;

    while (1){
        tempText = *text & 0xff;  // loads the first byte of the char array into tempText
        *list = tempText | *list; // keeps the previous value of tempText in the list

        if(tempText == 0){ break;} 
        *text += 1;                 // moves 1 char along the character array
        *list += 1;                 // moves 4 along the list since each 4 corresponds to 1 int
        j = *count;
        j++;
        *count = j;
    }
}

void work(){
    copycodes(text1, list1, &count); // loads addresses into the method call
    copycodes(text2, list2, &count);
}

void printlist(const int* lst){
  printf("ASCII codes and corresponding characters.\n");
  while(*lst != 0){
    printf("0x%03X '%c' ", *lst, (char)*lst);
    lst++;
  }
  printf("\n");
}

void endian_proof(const char* c){
  printf("\nEndian experiment: 0x%02x,0x%02x,0x%02x,0x%02x\n", 
         (int)*c,(int)*(c+1), (int)*(c+2), (int)*(c+3));
  
}

int main(void){
  work();

  printf("\nlist1: ");
  printlist(list1);
  printf("\nlist2: ");
  printlist(list2);
  printf("\nCount = %d\n", count);

  endian_proof((char*) &count);
}
