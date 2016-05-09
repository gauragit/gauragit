
#Given a hash with numeric values, 
#return the key for the smallest value.

def min_val(hash1)

key_min, value_min = hash1.first


#=begin
for key, val in hash1
  if value_min > val
    val_min = val
    key_min = key
  end
 
  
end

#=end
key_min

end


hash1 = {'a'=> 10, 'c'=> -5, 'b'=> 100}

print min_val(hash1)