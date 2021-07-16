#!/usr/bin/env python3
import time
gameSize = 5 #size of one side of the game -> 5 -> 5*5 Dots square

#this variables/arrays may only be changed by the System
#DO NOT CHANGE THESE!!! This might brake the Game
field = ['~'] * 40 #fieldarray
square = [' '] * 16 #squarearray
x = ['x'] * 5 #Dots
onPlayer = 0 #handles which player is on turn
runningGame = True
runningMenu = True
change = True

#this variables can be adjusted to support more users and more
#see advanced help (helpA) for mor information
players = ['A','B'] #Charcters of the different Players
maxplayers = len(players) #maximum number of Players
artIntel = [0,1]	#Artificial Intelligence preferences, which player is AI
AI_enabled = True   #Artificial Intelligence enabled
AI_thinkingtime = 1 #time the AI has to fill the field (makes the AI more humanuous)

#adapts the size of the field
def sizeFields(size):
	global x
	global field
	if(size < 5): # for size 4
		x[4] = ''
		for i in range(3,40,9):
			field[i] = ''
		for i in range(8,40,9):
			field[i] = ''	
		for i in range(31,40,1):
			field[i] = ''	
			
	if(size < 4): # for size 3
		x[3] = ''
		for i in range(2,40,9):
			field[i] = ''
		for i in range(7,40,9):
			field[i] = ''	
		for i in range(22,40,1):
			field[i] = ''	
			
	if(size < 3): # for size 2
		x[2] = ''
		for i in range(1,40,9):
			field[i] = ''
		for i in range(6,40,9):
			field[i] = ''	
		for i in range(13,40,1):
			field[i] = ''	

#prints the Playing field:
def printField():
	global gameSize
	sizeFields(gameSize)
	print("Turn of player ",players[onPlayer%maxplayers]) #prints which Player is on turn
	#prints the first line with the characters
	if(gameSize == 5):
		print("   {}   {}   {}   {}   {}".format("A","B","C","D","E"))
	elif(gameSize == 4):
		print("   {}   {}   {}   {}".format("A","B","C","D"))
	elif(gameSize == 3):
		print("   {}   {}   {}".format("A","B","C"))
	elif(gameSize == 2):
		print("   {}   {}".format("A","B"))
	
	#prints the field with the Dots
	print("{}  {} {} {} {} {} {} {} {} {}".format("0",x[0],field[0],x[1],field[1],x[2],field[2],x[3],field[3],x[4]))
	print("   {} {} {} {} {} {} {} {} {}".format(field[4],square[0],field[5],square[1],field[6],square[2],field[7],square[3],field[8]))
	print("{}  {} {} {} {} {} {} {} {} {}".format("1",x[0],field[9],x[1],field[10],x[2],field[11],x[3],field[12],x[4]))
	if(gameSize > 2): #adaption to size 3
		print("   {} {} {} {} {} {} {} {} {}".format(field[13],square[4],field[14],square[5],field[15],square[6],field[16],square[7],field[17]))
		print("{}  {} {} {} {} {} {} {} {} {}".format("2",x[0],field[18],x[1],field[19],x[2],field[20],x[3],field[21],x[4]))
	if(gameSize > 3): #adaption to size 4
		print("   {} {} {} {} {} {} {} {} {}".format(field[22],square[8],field[23],square[9],field[24],square[10],field[25],square[11],field[26]))
		print("{}  {} {} {} {} {} {} {} {} {}".format("3",x[0],field[27],x[1],field[28],x[2],field[29],x[3],field[30],x[4]))
	if(gameSize > 4): #adaption to size 5
		print("   {} {} {} {} {} {} {} {} {}".format(field[31],square[12],field[32],square[13],field[33],square[14],field[34],square[15],field[35]))
		print("{}  {} {} {} {} {} {} {} {} {}".format("4",x[0],field[36],x[1],field[37],x[2],field[38],x[3],field[39],x[4]))

# prints the Stats at the end
def getStats():
	global players
	global maxplayers
	playerPnt = [0]* maxplayers #points of each player
	ind = 0
	
	#counts the number of square a player got:
	for i in players:
		for j in square:
			if j == i:
				playerPnt[ind]  +=1		
		ind +=1
	winner = 0
	j = 0
	
	#decides which person is the winner
	for i in playerPnt:
		if(i > playerPnt[winner]):
			winner = j
		j+=1
	print("The Winner is Player {}".format(players[winner]))
	
	#prints the points for all Players
	for i in range(0,maxplayers,1):
		print("Player {} got {} Points".format(players[i], playerPnt[i]))
	print("\n----------------------")
	
# controlls if a square is complete
def controllSquares():
	global onPlayer
	global maxplayers
	global gameSize
	global change
	global square
	global players
	lf = 0
	s = 16
	#print("s: ",s)
	for i in range(0,s,1):
		if(i>0 and i%4 == 0):
			lf +=5
		if(square[i]==' '): #proofs for all four sides and writes the Character of the Player if it is not already signed
			a = field[i+lf]
			b = field[i+4+lf]
			c = field[i+5+lf]
			d = field[i+9+lf]
			if(a==b==c==d=='S'): #proofs the sides
				square[i] = players[onPlayer%maxplayers] #prints the new Player Char
				change = False #handles that the player gets a second turn

#controlls if all fields are filled and the game is finished
def controllAll():
	global field
	global runningGame
	allfilled = True
	for i in field:
		if(i =='~'):
			allfilled = False
			#print("not all filled")
	if(allfilled): #finish game routine
		printField()
		print("\n----------------------")
		print("The Game is over!\n")
		runningGame = False #stops the game
		getStats() #prints the stats

# proofs if the input is correct
def validLetters(i):
	global gameSize
	if(gameSize==5): #proofs if only the allowed letters are written for size 5
		switcher={
			'A':True, 'B':True,'C':True,'D':True,'E':True,'-':True,'0':True,'1':True,'2':True,'3':True,'4':True,
			'a':True, 'b':True,'c':True,'d':True,'e':True
		}
	elif(gameSize==4): #proofs if only the allowed letters are written for size 4
		switcher={
			'A':True, 'B':True,'C':True,'D':True,'-':True,'0':True,'1':True,'2':True,'3':True,
			'a':True, 'b':True,'c':True,'d':True
		}
	elif(gameSize==3): #proofs if only the allowed letters are written for size 3
		switcher={
			'A':True, 'B':True,'C':True,'-':True,'0':True,'1':True,'2':True,
			'a':True, 'b':True,'c':True
		}
	elif(gameSize==2): #proofs if only the allowed letters are written for size 2
		switcher={
			'A':True, 'B':True,'-':True,'0':True,'1':True,
			'a':True, 'b':True
		}
	return switcher.get(i,False)

#calculates the field value from the letters and numbers
#this is a sience for itself
def getValue(C):
	switcher={
			'A':0,'a':0,
			'B':1,'b':1,
			'C':2,'c':2,
			'D':3,'d':3,
			'E':4,'e':4,
			'0':0,
			'1':9,
			'2':18,
			'3':27,
			'4':36
			}
	return switcher.get(C,"error, wrong Char, if you get this, something went terribly wrong...")

#proofs if the input is valid: for example A1-A2 or A0-B0
def validate(input):
	valid = True;
	
	if(len(input)==5):			#proofs the length
		#print("valid length")
		for i in input:
			if(not validLetters(i) or not input[2]=='-'): #proofs the letters and if - is in the middle
				valid = False;
		if(input[0] == input[3]): # proofs if A = A
			#print("valid letters")
			if(abs(ord(input[1])-ord(input[4]))>1 or abs(ord(input[1])-ord(input[4]))==0): #proofs if the numbers |1-2| are < 2 but not 0
				valid = False
				print("invalid numbers")
		elif(input[1] == input[4]): # proofs if 0 = 0
			#print("valid numbers")
			if(abs(ord(input[0])-ord(input[3]))>1 or abs(ord(input[0])-ord(input[3]))==0): #proofs if the numbers of |A-B| are < 2 but not 0
				valid = False
				print(ord(input[1]))
				print(ord(input[4]))
				print("invalid letters")
		else:
			valid = False
			print("invalid Numbers and letters (only one should change)")
	else:
		valid = False
	if(valid and not interpret(input, 1)): #proofs if the Field is already taken
		print("Field is already taken. Choose another Field.")
		valid = False
	return valid;

# sets the line from Point CN -> f.e. A0 in the direction right(= 0) or down(=1)
def setLine(C, N, direction):
	global field
	print("Line set...")
	start = getValue(C)
	start = start + getValue(N)
	if(direction == 0):
		field[start] = 'S'
	else:
		field[start+4] = 'S'

#proofs if line is already taken, works like the setLine, but returns a boolean
def proofLine(C, N, direction):
	start = getValue(C)
	start = start + getValue(N)
	if(direction == 0):
		if(field[start] == 'S'):
			return False
		else:
			return True
	else:
		if(field[start+4] == 'S'):
			return False
		else:
			return True

#interprets the input, there are 2 modes: 0 -> line gets set, 1 -> line gets proofed if it is already taken
def interpret(input, mode):
	if(mode == 0): #set mode
		if(input[0]<input[3]): #adapts the input that the smaller Char is taken
			setLine(input[0],input[1],0)
		elif(input[0]>input[3]):
			setLine(input[3],input[1],0)
		else:
			if(input[1]<input[4]): #adapts the input that the smaller Number is taken
				setLine(input[0],input[1],1)
			else:
				setLine(input[0],input[4],1)
	else: #proof mode
		value = True
		if(input[0]<input[3]):
			value = proofLine(input[0],input[1],0)
		elif(input[0]>input[3]):
			value = proofLine(input[3],input[1],0)
		else:
			if(input[1]<input[4]):
				value =	proofLine(input[0],input[1],1)
			else:
				value = proofLine(input[0],input[4],1)
		return value

#makes the turn of the AI
def makeAIturn():
	global gameSize
	global AI_thinkingtime
	lf = 0
	maxN = (gameSize-1)**2
	count = 0					#for counting the sides
	found = False 				#to check if field is found
	time.sleep(AI_thinkingtime) #how long the AI takes to solve fill in a field
	s= gameSize-1
	s2 = 5
	#s2 =gameSize+1
	for i in range(0,maxN,1):
		if(i>0 and i%s == 0): #adapts to the different sizes
			lf +=s2
		if(field[i+lf] == 'S'):  #checks all the four sides
			count +=1
		if(field[i+4+lf] == 'S'):
			count +=1
		if(field[i+5+lf] == 'S'):
			count +=1	
		if(field[i+9+lf] == 'S'):
			count +=1
			#print("count: ",count)
		if(count == 3): #if three sides are already filled
			found = True
			print("AI: Found an 3 side square")
			if(field[i+lf] == '~'): #fills in the field
				field[i+lf] = 'S'
				#print("field[{}+{}]".format(i, lf))
				break
			elif(field[i+4+lf] == '~'):
				field[i+4+lf] = 'S'		
				#print("field[{}+4+{}]".format(i, lf))
				break
			elif(field[i+5+lf] == '~'):
				field[i+5+lf] = 'S'		
				#print("field[{}+5+{}]".format(i, lf))
				break
			elif(field[i+9+lf] == '~'):
				field[i+9+lf] = 'S'
				#print("field[{}+9+{}]".format(i, lf))
				break
			else:
				#print("no valid move found")
				found = False
			
		count = 0
	lf = 0
	if(not found):
		for i in range(0,maxN,1): #search for sides < 2
			if(i>0 and i%s == 0): #adapts to the different sizes
				lf +=s2
			if(field[i+lf] == 'S'): #checks all the four sides
				count +=1
			if(field[i+4+lf] == 'S'):
				count +=1
			if(field[i+5+lf] == 'S'):
				count +=1	
			if(field[i+9+lf] == 'S'):
				count +=1
				#print("count2: ",count)
			if(count < 2): #if less than two sides are already filled
				found = True
				print("AI: Found a not 2 sided field")
				if(field[i+lf] == '~'): #fills the field
					field[i+lf] = 'S'
					#print("field[{}+{}]".format(i, lf))
					break
				elif(field[i+4+lf] == '~'):
					field[i+4+lf] = 'S'		
					#print("field[{}+4+{}]".format(i, lf))
					break
				elif(field[i+5+lf] == '~'):
					field[i+5+lf] = 'S'			
					#print("field[{}+5+{}]".format(i, lf))
					break
				elif(field[i+9+lf] == '~'):
					field[i+9+lf] = 'S'
					#print("field[{}+9+{}]".format(i, lf))
					break
				else:
					#print("no valid move found")
					found = False
			count = 0
		lf = 0
	if(not found):
		for i in range(0,40,1): #searches for an free field and fills it
			if(field[i]== '~'):
				field[i]='S'
				found = True
				break
			
#handles the drawing of a line of a human player
def drawline():
	answer = input("Draw a line (for example: A0-A1):\n");
	valid = validate(answer); #validates input
	if(not valid):
		while(not valid):
			answer = input("The Input was not valid, please write for ex.: A0-B0\n Draw a line:\n");
			valid = validate(answer);
	interpret(answer,0) #draws the line
	
#handles the different turns
def turn():
	global onPlayer
	global change
	global AI_enabled
	global artIntel
	global maxplayers
	change = True
	printField() #prints the field
	if(AI_enabled):
		if(artIntel[onPlayer%maxplayers]): # handles the AI prefs and turns
			makeAIturn()
		else:
			drawline()
	else:
		drawline()
	controllSquares() 	#controlls for closed squares
	controllAll()		#controlls if all fields are filled
	if(change):			#changes the player on turn
		onPlayer += 1

#handles a new game
def newGame():
	global runningGame
	global onPlayer
	global field
	global x
	global square
	global change
	
	#resetting the fields
	field = ['~'] * 40
	x = ['x'] * 5
	onPlayer = 0
	square = [' '] * 16 
	runningGame = True
	change = True
	while(runningGame): #runs the turns during the game
		turn()

#prints the helpBox and Infos
def helpBox(mod):
	print("Commands: ")
	print("size2 , size3, size4, size5 -> changes the size")
	print("AIEnable, AIDisable -> enables and disables the AI")
	print("newGame -> makes a new Game")
	print("quit -> quits the Program")
	print("help, helpA -> help Box / advanced Features\n")
	if(mod == 1):
		print("Advanced Features, this features are hardcoded:")
		print("- the players[] array defines the number of Players and their Char,")
		print("  if we make the Game with more Players, the variable maxplayers has to be increased too")
		print("- the artIntel[] array defines which Player is an AI Player (1 is AI, and 0 is non AI) \n")
	print("Some additional Info:")
	print("How to play Dots n' Boxes: https://www.youtube.com/watch?v=FLNPAKBJavY")
	print("or read the Wikipedia Article about it: https://en.wikipedia.org/wiki/Dots_and_Boxes")
	print("Disclaimer: The Commands are not available while a Game is running.")
	print("Please write the Commands like they are showed above, otherwise the Program doesn't understand it.")
	print("\n ********** Enjoy the Game **********")

#handles the input menu
def menu(input):
	global gameSize
	global AI_enabled
	global runningMenu
	if(input[0:4]=='size'):
		if(input[4]=='2'):
			gameSize = 2
		elif(input[4]=='3'):
			gameSize = 3
		elif(input[4]=='4'):
			gameSize = 4
		elif(input[4]=='5'):
			gameSize = 5
		else:
			print("unknown Size")
	elif(input == 'AIEnable'):
		AI_enabled = True
	elif(input == 'AIDisable'):
		AI_enabled = False
	elif(input == 'newGame'):
		newGame()
	elif(input == 'quit'):
		runningMenu = False
	elif(input == 'help'):
		helpBox(0)
	elif(input == 'helpA'):
		helpBox(1)
	else:
		print("unknown Command, for help write 'help', please write the Commands like they are listed in the Helpbox")


# Main Menu
print("----------------------------------------")
print("       Welcome to Dots n' Boxes         ")
print("Made for an exercise of University Basel")
print("      during Corona-Time April 2021     ")
print("----------------------------------------\n")

helpBox(0)
while(runningMenu):
	menu(input("\nwrite a Command: "))
	