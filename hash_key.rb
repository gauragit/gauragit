

def min(hash_table)
  min_k = nil
  min = hash_table.values[0]
  
  for itr_k, itr_v in hash_table
    
    if itr_v <= min
      min = itr_v
      min_k = itr_k 
    end  
  
  end
  
print min_k  
end




hash_table = {"k" => 2, "h" => 3, "j" => 1}
min(hash_table)
