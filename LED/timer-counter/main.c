#include <avr/io.h>

int main(void)
{
	DDRB = 0b01111111;
	PORTB = 0b00000000;
	DDRD = 0b01111111;
	PORTD = 0b00000000;
	TCCR1B |= (1 << CS10) | (1 << CS11);
	uint8_t LEDNumber[2];
	while(1)
	{
		if(TCNT1 > 2232)
		{
			TCNT1 = 0;
			PORTB = (1 << LEDNumber[0]);
			LEDNumber[0]++;
			if(LEDNumber[0] > 6)
			{
				LEDNumber[0] = 0;
				PORTD = 1 << LEDNumber[1];
				LEDNumber[1]++;
				if(LEDNumber[1] > 6)
				{
					LEDNumber[1] = 0;
				}
			}
		}
	}
}

