class Dog:

    #initiallizer. similar to no-args constructor
    #IMPORTANT: noargs constructors only work when there are no other constructors in this class
    # 'pass' is only used because python expects at least one line statement to be used. it does nothing
    # self in Python is equivalent to this in C++ or Java
    # def __init__(self):
    #     pass

    # def __init__(self):
    #     self.foo=23
    #     self._bar=11
    #     self.__baz=42

    def __init__(self , name):
        self.name = name

    def __init__(self , name , age):
        self.name = name
        self.age = age

    def bark(self):
        print("bark, bark!")

    def birthday(self):
        self.age += 1

    def setBuddy(self, buddy):
        self.buddy=buddy
        buddy.buddy=self
