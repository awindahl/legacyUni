/*
 prime.c
 By David Broman.
 Exercise solved by Alexander Windahl.
 Last modified: 2015-09-15
 This file is in the public domain.
*/


#include <stdio.h>
#include <math.h>

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


int main(void){
  printf("%d\n", is_prime(17));  // 11 is a prime.      Should print 1.
  printf("%d\n", is_prime(32)); // 383 is a prime.     Should print 1.
  printf("%d\n", is_prime(100000)); // 987 is not a prime. Should print 0.
}

