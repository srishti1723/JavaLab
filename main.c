#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i,n,sum=0;
    printf("/nEnter the value of n:");
    scnf("%d",&n);
    for(i=0;i<n;i++)
    {
        sum=sum+i;
    }
        printf("%d",sum);
    return 0;
}
