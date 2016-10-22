#include <avr/io.h>
#include <util/delay.h>

int main(void)
{
	DDRB |= (1 << PINB0);
	PORTB ^= (1 << PINB0);
	DDRB |= (1 << PINB2);
	DDRB &= ~(1 << PINB1);
	PORTB |= (1 << PINB1);
	
	int Pressed = 0;
	int pressed_confidence_level = 0;
	int released_confidence_level = 0;
	
	while(1)
	{
		
		if(bit_is_clear(PINB, 1))
		{
			pressed_confidence_level ++;
			if(pressed_confidence_level > 200)
			{
				if(Pressed == 0)
				{
					PORTB ^= (1 << PINB0);
					PORTB ^= (1 << PINB2);
					Pressed = 1;
				}
				pressed_confidence_level = 0;
			}

		} 
		else
		{
			released_confidence_level ++;
			if(released_confidence_level > 200)
			{
				Pressed = 0;
				released_confidence_level = 0;
			}

		}
	
	}
	
}