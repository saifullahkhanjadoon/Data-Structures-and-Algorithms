public class DEQueue{
	int [] q;
	int front,rear;

	public DEQueue(){
		this.front=-1;
		q=new int[4];
		this.rear=-1;
	}
	public void insertFront(int x){
		if(isFull()){
			System.out.println("Qequeue is full");
			return;
		}
		if (isEmpty()){
			front=rear=0;
			q[front]=x;
		}else if(front==0){
			front=q.length -1;
			q[front]=x;
		}else{
			front--;
			q[front]=x;
		}

	}
	public void insertRear(int x){
		if(isFull()){
			System.out.println("Qequeue is full");
			return;
		}
		if(isEmpty()){
			front=rear=0;
			q[rear]=x;
		}else if(rear==q.length-1){
    		rear=0;
    		q[rear]=x;
		}else{
			rear++;
			q[rear]=x;
		}
	}
	public void deleteFront(){
		if(isEmpty()){
			System.out.println("DEQueue is empty");
			return;
		}
		int x=q[front];
		if(front==rear){
			rear=front=-1;
		}else if(front>=4){
			front=0;
		}else{
			front++;
		}
	}

	public void deleteRear(){
		if(isEmpty()){
			System.out.println("DEQueue is empty");
			return;
		}
		int x=q[rear];
		if(front==rear){
			rear=front=-1;
		}else if(rear==0){
			rear=q.length-1;
		}else{
			rear--;
		}
	}
	public boolean isFull(){
return ( (front == 0 && rear == q.length-1) || (front == rear+1) );}

	public boolean isEmpty(){
		return front==-1;}

	public void display(){
		if(isEmpty()){
			System.out.println("Empty");
			return;}
			System.out.println("dequeue : ");
		if(rear>=front){
			for(int i=front;i<=rear;i++){
			System.out.println(q[i]+"");
		}}
		else{
			for (int i=front;i<4;i++){
			System.out.println(q[i]+"");
		}for( int i=0;i<=rear;i++){
			System.out.println(q[i]+"");

		}
		}
		System.out.println();
		System.out.println("front: "+front+ " rear : "+rear);}




	public static void main(String[] args){
			DEQueue obj=new DEQueue();

			obj.insertFront(7);
			obj.insertRear(8);
			obj.insertRear(9);
			obj.deleteFront();
			obj.insertFront(6);
			obj.deleteRear();

			obj.display();



}
}