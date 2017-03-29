/*
sieves.c
partially by Alexander Windahl
main method defined by David Broman
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


int print_sieves(int n){
    int q = 0;
    int p = 0;
    int u = 0;
    int i = 0;
    int j = 0;
    int *sieveP = malloc(sizeof(int)*n);

    printf ("These are the prime numbers: ");
    printf ("\n");
    
    for (u=0; u<n; u++){            // sets all the values of sieveP from 0 to n-1
        sieveP[u]=u;
    }
    for(p = 2; p<sqrt(n); p++){     // starts the sieve
        j = pow(p,2);
        i = 0;
        for(q=0; i<n; q++){
            i=j+p*q;                              // the following fail-safe is needed to prevent memory corruption
            if(i<n) {sieveP[i] = 0;}             // as long as i<n, # where there is a prime, otherwise 0
            }
         }
    for(u=2; u<n; u++){
        if(sieveP[u]>1){              // prints all numbers that arent 0 and 1
            print_number(u);
        }
    }
    free(sieveP);
}

// 'argc' contains the number of program arguments, and
// 'argv' is an array of char pointers, where each
// char pointer points to a null-terminated string.
int main(int argc, char *argv[]){
  if(argc == 2){
    print_sieves(atoi(argv[1]));
    }
  else{
    printf("Please state an interger number.\n");
    }
  return 0;
}           
