#Stack Simulation using push and pop

class Stack


def initialize(max)
  @index = -1
  @max_index = max - 1
  @arr = []
end

def push(val)
  if @index + 1 > @max_index
    print "stack overflow"  
  else
    @index = @index + 1  
    @arr[@index]  = val
    
  end  
@arr 
end 

 def pop()
   if @index == -1
    print "can't pop"
   else
     print @arr[@index], " for pop "
     @arr[@index] = nil
     @index = @index - 1 
 
   end
 @arr  
 end
  
end


t = Stack.new(2)

print t.push(10)
print t.push(20)
print t.push(30)


print  t.pop()
print  t.pop()
# t.pop()
print t.pop()




