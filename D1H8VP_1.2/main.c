#include <stdio.h>
#include <stdlib.h>
void pelda_1();
int main()
{
fajl();
return 0;
}
void fajl() {
FILE *fp;
char ch;
char fnev[50];
printf("filenev: ");
scanf("%s", fnev);
fp = fopen(fnev, "w");
printf("üzenet ");
while( (ch = getchar()) != '#') {
putc(ch, fp);
}
fclose(fp);
fp = fopen(fnev, "r");
while ( (ch = getc(fp)) != EOF ) {
printf("%c",ch);
}
fclose(fp);
return 0;
}
