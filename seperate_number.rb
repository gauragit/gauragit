#given a string example 100000.
#seperate it with , after three decimals
# 10000 will be 10,000


def separate_with_comma(n)
   # get the length of string which needs to be added to commas
   len = n.length() - 1
   final_array = []
   #count for number of digits after which , has to put
   count = 1
   j = 0

      
   len.downto(0) do |i|
     
     #index is right to put comma
     if count % 3 == 0 && i !=0
        final_array[j] = n[i]
        j = j + 1
        final_array[j] = ','
        j = j + 1
        count = 1
        
     #store in new array the final list   
     else
        final_array[j] = n[i]
        j = j + 1
        count = count + 1 
         
     end
      
    end     
    
print final_array
end



separate_with_comma("1000")
