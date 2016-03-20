#include <iostream>
#include <algorithm>
using namespace std;

static const int ERROR = -100;
static const int ARRAY_SIZE = 35;

void makeBaseList(int list[], string input);
int converter(int base, string input);

int main(){
	string input1, input2;
	while(cin >> input1 >> input2){
		int convert[ARRAY_SIZE];
		makeBaseList(convert, input1);
		int base1 = ERROR, base2 = ERROR;
		for(int i = 2; i < 37; i++){
			//remember to include <algorithm> before
			//using "find"
			int *position = find(convert, 
							convert + ARRAY_SIZE, 
							converter(i, input2));
			
			if(converter(i, input2) != ERROR && 
				position != convert + ARRAY_SIZE){
				base2 = i;
				base1 = position - convert + 2;
				break;
			}
		}
		
		if(base1 != ERROR){
			cout << input1 << " (base " << base1 <<
			") = " << input2 << " (base " << base2 <<
			")" << endl; 
		}else{
			cout << input1 << " is not equal to " <<
			input2 << " in any base 2..36" << endl;
		}
	}
	
	return 0;
}

void makeBaseList(int list[], string input){
	for(int i = 0; i < ARRAY_SIZE; i++){
		list[i] = converter(i + 2, input);
	}
}

int converter(int base, string input){
	int sum = 0;
	int decimal = 1;
	for(int i = input.length() - 1; i > -1; i--){
		if(input[i] > 64 && input[i] < 91){
			if(input[i] - 55 >= base){return ERROR;}
			sum += (input[i] - 55) * decimal;
		}else{
			if(input[i] - 48 >= base){return ERROR;}
			sum += (input[i] - 48) * decimal;
		}
		
		decimal *= base;
	}
	
	return sum;
}
