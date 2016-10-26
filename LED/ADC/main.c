#include <avr/io.h>
#include <util/delay.h>
#include <stdlib.h>
#include <avr/interrupt.h>

#define D0 eS_PORTD0
#define D1 eS_PORTD1
#define D2 eS_PORTD2
#define D3 eS_PORTD3
#define D4 eS_PORTD4
#define D5 eS_PORTD5
#define D6 eS_PORTD6
#define D7 eS_PORTD7
#define RS eS_PORTC6
#define EN eS_PORTC7

#include "lcd.h"

int main(void)
{
	DDRD = 0xFF;
	DDRC = 0xFF;
	Lcd8_Init();
	
	ADCSRA |= 1 << ADPS2;
	ADMUX |= 1 << ADLAR;
	ADMUX |= 1 << REFS0;
	ADCSRA |= 1<< ADIE;
	ADCSRA |= 1 << ADEN;
	
	sei();
	
	ADCSRA |= 1 << ADSC;

	while(1)
	{
		
	}
}

ISR(ADC_vect)
{
	uint8_t theLow = ADCL;
	uint16_t tenBitValue = ADCH << 2 | theLow >> 6;
	
	char adcResult[4];
	
	itoa(tenBitValue, adcResult, 10);
	Lcd8_Set_Cursor(1, 1);
	Lcd8_Write_String(adcResult);
	
	Lcd8_Write_String("    ");	
	
	ADCSRA |= 1 << ADSC;

}
