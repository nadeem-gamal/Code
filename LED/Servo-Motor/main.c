#include <avr/io.h>
#include <util/delay.h>

int main(void)
{
	DDRD |= 0xFF;
	TCCR1A |= 1<<WGM11 | 1<<COM1A1 | 1<<COM1A0;
	TCCR1B |= 1<<WGM12 | 1<<WGM13 | 1<<CS10;
	ICR1 = 19999;
	
	OCR1A = ICR1 - 1700;
	//number -> angle
	//1500 -> 0
	//1000 -> -90
	//2000 -> +90
	
	
	while(1)
	{
//		for(int value = 800;value <= 2200; value+=100)
//		{
//			OCR1A = ICR1 - value;
//			_delay_ms(100);
//		
//		}



//		OCR1A = ICR1 - 800;
	//	_delay_ms(100);
		//OCR1A = ICR1 - 2200;
		//_delay_ms(100);
	}
}