
#Reverse the string
#exampel Hello Ruby will return Ruby Hello
#when using this method

def reverse_each_word(sentence)

  #reverse the complete string to allign to right position  
  sentence = sentence.reverse()
  #tokenize the string delimeter is " "
  *total = sentence.split()
  arr = []
  count = 0
  str = ""
  
  len = total.length
  #Now reverse the strings which are in right position
  for tokens in total
   count = count + 1 
   str = str + tokens.reverse
   
   if count != len
    str = str + " " 
    
   end    
  end
  print str 
 
end

print reverse_each_word("Hello Aello")

