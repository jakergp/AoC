nums = ['one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
sum = 0

def obtainNums(string):
    num1 = None
    for i in range (len(string)):
        if string[i].isnumeric():
            if num1 is None:
                num1 = string[i]
            num2 = string[i]
        else:
            for j in range (2, 6):
                for number in nums: 
                    if string[i:i+j] == number:
                        index = str(nums.index(number) + 1)
                        if num1 is None:
                            num1 = index 
                        num2 = index
                    
    return num1 + num2
 
with open('calibration.txt', 'r') as file:
    for line in file:
        sum += int(obtainNums(line))
        
print(sum)