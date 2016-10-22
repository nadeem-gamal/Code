#include <avr/io.h>
#include <util/delay.h>

void processPressedButton(int buttonPressed);
void processReleasedButton(int buttonReleased);

int pressed_confidence_level[2];
int released_confidence_level[2];
int pressed[2];
int LEDNumber[2];

int main(void)
{
	DDRB = 0b01111111;
	DDRD = 0b01111111;
	PORTB = 0b10000000;
	PORTD = 0b10000000;
	
	
	while(1)
	{
		if(bit_is_clear(PINB, 7))
		{
			processPressedButton(0);
		}
		else
		{
			processReleasedButton(0);
		}
		
		if(bit_is_clear(PIND, 7))
		{
			processPressedButton(1);
		}
		else
		{
			processReleasedButton(1);
		}
	}
}



void processPressedButton(int buttonPressed)
{
	pressed_confidence_level[buttonPressed] ++;
	if(pressed_confidence_level[buttonPressed] > 500)
	{
		if(pressed[buttonPressed] == 0)
		{
			pressed[buttonPressed] = 1;
			if(buttonPressed == 0) PORTB |= (1 << LEDNumber[buttonPressed]);
			if(buttonPressed == 1) PORTD |= (1 << LEDNumber[buttonPressed]);
			LEDNumber[buttonPressed] ++;
			if(LEDNumber[buttonPressed] > 6)
			{
				for(int i = 0; i < 10; i++)
				{
					if(buttonPressed == 0) PORTB = 0b11111111;
					if(buttonPressed == 1) PORTD = 0b11111111;
					_delay_ms(10);
					if(buttonPressed == 0) PORTB = 0b10000000;
					if(buttonPressed == 1) PORTD = 0b10000000;
					_delay_ms(10);
				}
				LEDNumber[0] = 0;
				LEDNumber[1] = 0;
				PORTB = 0b10000000;
				PORTD = 0b10000000;
			}
		}
		pressed_confidence_level[buttonPressed] = 0;
	}
}

void processReleasedButton(int buttonReleased)
{
	released_confidence_level[buttonReleased] ++;
	if(released_confidence_level[buttonReleased] > 500)
	{
		pressed[buttonReleased] = 0;
		released_confidence_level[buttonReleased] = 0;
	}
}