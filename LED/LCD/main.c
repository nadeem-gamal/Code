#include <avr/io.h>
#include <util/delay.h>

#define MrLCDsCrib 				PORTB
#define DataDir_MrLCDsCrib 		DDRB
#define MrLCDsControl 			PORTD
#define DataDir_MrLCDsControl 	DDRD
#define LightSwitch 			PIND5
#define ReadWrite 				PIND7
#define BiPolarMood 			PIND2

void Check_IF_MrLCD_isBusy(void);
void Peek_A_Boo(void);
void Send_A_Command(unsigned char command);
void Send_A_Character(unsigned char character);

int main(void)
{
	DataDir_MrLCDsControl |= 1<<LightSwitch | 1<<ReadWrite | 1<<BiPolarMood;
	_delay_ms(15);
	
	
	
	Send_A_Command(0x01);
	_delay_ms(2);
	
	Send_A_Command(0x38);
	_delay_us(50);
	
	Send_A_Command(0b00001110);
	_delay_us(50);
	
	
	Send_A_Character(0x41);

	while(1)
	{

	}
}

void Check_IF_MrLCD_isBusy()
{
	DataDir_MrLCDsCrib = 0;
	MrLCDsControl |= 1<<ReadWrite;
	MrLCDsControl &= ~ 1<<BiPolarMood;
	
	while(MrLCDsCrib >= 0x80)
	{
		Peek_A_Boo();
	}
	
	
	DataDir_MrLCDsCrib = 0xFF;
}

void Peek_A_Boo()
{
	DataDir_MrLCDsControl |= 1<< LightSwitch;
	asm volatile ("nop");
	asm volatile ("nop");
	MrLCDsControl &= ~ 1<<LightSwitch;
}

void Send_A_Command(unsigned char command)
{
	Check_IF_MrLCD_isBusy();
	MrLCDsCrib = command;
	MrLCDsControl &= ~ (1<<ReadWrite|1<<BiPolarMood);
	Peek_A_Boo();
	MrLCDsCrib = 0;
}

void Send_A_Character(unsigned char character)
{
	Check_IF_MrLCD_isBusy();
	MrLCDsCrib = character;
	MrLCDsControl &= ~ (1<<ReadWrite);
	MrLCDsControl |= 1<<BiPolarMood;
	Peek_A_Boo();
	MrLCDsCrib = 0;

}
