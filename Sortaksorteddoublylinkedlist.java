// Problem Link : https://www.geeksforgeeks.org/problems/sort-a-k-sorted-doubly-linked-list/1

// Solution 

class Solution {
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        // Code here
        PriorityQueue<DLLNode> queue=new PriorityQueue<>((a,b)->a.data-b.data);
        if(head==null)return head;
        
        for(int i=0;head!=null&&i<=k;i++){
            queue.offer(head);
            head=head.next;
        }
        DLLNode newNode=null;
        DLLNode current=null;
        while(!queue.isEmpty()){
            if(newNode==null){
                newNode=queue.poll();
                newNode.prev=null;
                newNode.next=null;
                current=newNode;
            }
            else{
                current.next=queue.poll();
                current.next.prev=current;
                current=current.next;
            }
            if(head!=null){
                queue.offer(head);
                head=head.next;
            }
        }
        current.next=null;
        return newNode;
    }
}
