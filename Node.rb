class Node1
   #Node1 has 
   #data: data to store per: node 
   #pointing to next node: next
   
   attr_accessor:data,:next
   
   def initialize(data = nil)
      @data = data
    end  
end



 class LinkList
    #LinkList has head pointing to first node
    #Adding node at the start
    #A new LinkList will have its unique head
    #creating Node the container of data and next pointer inside LinkList
    
    attr_accessor :head
   
    def initialize(data)
       if @head == nil
          @head = Node1.new(data)
          @head.next = nil
       else
          @head1 = Node1.new(data)
          @head1.next = @head
          @head = @head1   
       end
    end
   
    def add1(data)
       if @head == nil
          @head = Node1.new(data)
          @head.next = nil
       else
          #head1 is var which will be made head
          #as we are adding node at the start
          
          head1 = Node1.new(data)
          head1.next = @head
          @head = head1   
       end
    end
   
    def display()
       ptr = @head
    
    while ptr!= nil
       print ptr.data," "
       ptr = ptr.next
    end  
    
   end
   
end

l1 = LinkList.new(10)
l1.add1(20)
l1.add1(30)
l1.add1(40)
l1.display()
     
     
     
