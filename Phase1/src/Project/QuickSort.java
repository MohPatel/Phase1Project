package Project;

public class QuickSort {
	
	public void sort(String[] fileNames) {sort(fileNames,0,fileNames.length-1); }
	
	private void sort(String[] fileNames, int start, int end) {
		if(start<end)
		{
			int p = partition(fileNames,start,end);
			sort(fileNames,start,p-1);
			sort(fileNames,p+1,end);
		}
		
	}
	
	private int partition(String[] numbers, int start,int end)
	{
		String pivot= numbers[end];
		int x= start-1;
		for(int i=start; i <= end; i++)
		{
			if(numbers[i].compareTo(pivot) < 0)
			{
				x++;
				swap(numbers,x,i);
			}
		}
		swap(numbers,x+1,end);
		return x+1;
	}
	
	private void swap(String[] numbers, int j, int k)
	{
		String temp = numbers[j];
		numbers[j]=numbers[k];
		numbers[k] = temp;
		
	}
}
