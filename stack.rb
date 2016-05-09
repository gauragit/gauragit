
def fact(n)
  if (n == 1)
    return 1
  else
    n * fact(n -1)
  end  
end


print fact(4)
