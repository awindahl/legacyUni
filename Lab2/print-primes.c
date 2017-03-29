/*
 print-prime.c
 By David Broman.
 Exercise solved by Alexander
 Last modified: 2015-09-15
 This file is in the public domain.
*/


#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define COLUMNS 6
static int counter = 0;

void print_number(int n){
    counter ++;
    printf("%10d ", n);
    if(counter == COLUMNS){
        counter = 0;
        printf("\n");
    }
}

int is_prime(int n){
       int i;
       int j;
       for(i=2; i<=n; i++)
       {
            if(n%i==0)
            { 
                break;
            }
        }
        if(i==n) 
        {
            j = 1; 
        }
        else j=0;

        return j;
}


void print_primes(int n){
    // Should print out all prime numbers less than 'n'
    // with the following formatting. Note that
    // the number of columns is stated in the define
    // COLUMNS
    int i;
    for (i=0; i<n;i++){
        if(is_prime(i)==1){
            print_number(i);
        }
    }
}
// 'argc' contains the number of program arguments, and
// 'argv' is an array of char pointers, where each
// char pointer points to a null-terminated string.
int main(int argc, char *argv[]){
  if(argc == 2){
    print_primes(atoi(argv[1]));
    }
  else{
    printf("Please state an interger number.\n");
    }
  return 0;
}           
