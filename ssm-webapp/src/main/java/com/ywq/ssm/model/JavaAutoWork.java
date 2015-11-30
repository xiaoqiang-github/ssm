package com.ywq.ssm.model;

public class JavaAutoWork {

	public static void main(String[] args) {
		//computeJiOu();//3
		//sum();
		int[] intArr = {3,5,1,7,0,6,9};
		                
		quickSort(intArr,0,intArr.length-1);
		for(int i:intArr){
			System.out.println(i);
		}
	}

	public static void quick_Sort(int[] arr,int left,int right){
		int i = left;
		int j = right;
		int key = arr[left];
		
		
		
	}
	
	/**
	 * 1. 用代码实现快速排序算法（可以查询快速排序算法原理，但是不要照抄代码，自己想想，手动实现下）
	 */
	public static int speedOrder(int[] arr,int left,int right){
		int i = left;
		int j = right;
		int key = arr[left];
		
		while(i<j){
			//  <---  向前
			while(j>i && arr[j]>key){
				j--;
			}
			
			if(i<j){
				arr[i] = arr[j];
				i++;
			}
			
			// --->  向后
			while(i<j && arr[i]<key){
				i++;
			}
			
			if(i<j){
				arr[j]=arr[i];
				j--;
			}
		}
		arr[i] = key;
		return i;
	}
		
	public static void quickSort(int s[], int l, int r){
		if (l < r){
			int i = speedOrder(s, l, r);
			quickSort(s, l, i-1);
			quickSort(s, i+1, r);
		}
	}
	
	/**
	 * 2. 编写程序求1！+2！+....15！的和并显示，要求使用方法完成
	 * 1*1+  2*2+2*1   +3*3+3*2+3*1+  ...+  15..
	 */
	public static void sum(){
		int total = 3;
		int sum = 0;
		for(int i=1;i<=total;i++){
			sum+=diGuiJieCheng(i);
			System.out.println();
		}
		System.out.println(sum);
	}
	
	//递归阶乘 
	public static int diGuiJieCheng(int m){
		if(m<=0){
			return 0;
		}
		if(m==1){
			return 1;
		}else{
			return m*diGuiJieCheng((m-1));
		}
		
	}
	
	/**
	 * 3.定义一个由整数组成的数组，要求求出其中的奇数个数和偶数个数
	 */
	private static void computeJiOu() {
		
		int[] intArr = {99,2,3,4,5,6,7,188,187,9};
		int ji = 0;
		int ou = 0;
		for(int temp : intArr){
			if(temp%2==0){
				ou++;
				System.err.println("偶数："+temp);
			}else{
				ji++;
				System.out.println("奇数："+temp);
			};
		}
		
		System.out.println("奇数个数："+ji+",偶数个数为："+ou);
	}
	
	/**
	 * 4; 设计一个表示用户的User类，
	 * 类中的变量有   用户名、口令和记录用户个数的变量   
	 * 定义类的3个构造方法（无参、为用户名赋值、为用户名和口令赋值）、设置用户名和口令的方法。
	 */
	class User{
		private String userName;//  用户名
		private String  password;// 口令 
		private Integer userCount;//记录用户个数
		
		//无参
		public User(){}
		
		//为用户名赋值
		public User(String userName){
			this.userName = userName;
		}
		
		//为用户名和口令赋值
		public User(String userName,String password){
			this.userName = userName;
			this.password = password;
		}
		
		//getter and setter
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}
}
