from dictFunc import *
import ioFunctions
from Dog import *


#print
print("hello")
ioFunctions.myFunc("hello", "world")


#A for loop is used for iterating over a sequence
# (that is either a list, a tuple, a dictionary, a set, or a string).
#list
myList = [1,2,3,4,5,6]
for n in myList:
    print(n)

for c in "cucumber":
    if c == 'm':
        break
    print(c)

for x in range(2,6):
    print(x+3)
else:
    print("finally finished")

#1 to 30 in increments of 2
for x in range(1,30,2):
    print(x+3)

for x in [1,2,3]:
    print(x)



#dictionary
myDict = {1:'apple',2:'orange'}

printDictionaryKeys(myDict)
printDictionaryValues(myDict)

print("\n")
print(myDict[1])
nestedDict = {"fruits":myDict,"vegetables":{1:"carrot",2:"lettuce",3:"potato"}}
print(nestedDict["vegetables"][2])

d = {'a': 1, 'b': 2}
print(d)
d['a'] = 100  # existing key, so overwrite
d['c'] = 3  # new key, so add
d['d'] = 4
print(d)



#Booleans
isTrue = True #True is a reserved word in python syntax
print(type(isTrue))

#tupules
#A tuple is a collection which is ordered and unchangeable. In Python tuples are written with round brackets.
thistuple = ("apple", "banana", "cherry", "orange", "kiwi", "melon", "mango")
print(thistuple[2:5])
print(myList[1:3])


#A set is a collection which is unordered and unindexed. In Python sets are written with curly brackets.
thisset = {"apple", "banana", "cherry"}
print("banana" in thisset)
print(thisset)
thisset.add("banana")
print(thisset)


#Classes
dog1 = Dog("borkey",5)
print(dog1.name)

print(dog1.name +" is "+str(dog1.age)+" years old")
dog1.bark()
dog1.birthday()

dog2 = Dog("ozzy",2)
# print(dog1.name + "'s buddy is " + dog1.buddy.name) # this line returns an error if 'buddy' attribute is not set yet
dog1.setBuddy(dog2)
print(dog1.name + "'s buddy is " + dog1.buddy.name)
print(dog2.name + "'s buddy is " + dog2.buddy.name)


#dir function - lists all functions and attributes of an object
print(dir(dog1))

