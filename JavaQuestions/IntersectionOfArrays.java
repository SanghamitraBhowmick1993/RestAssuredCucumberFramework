package JavaQuestionsPart3;

public class IntersectionOfArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[] = {2,5,3,7};
		int y[] = {9,7,5,3};
		
		int z[] = new int[x.length + y.length];
		for(int i =0;i<(x.length);i++){
			for(int j =0;j<(y.length);j++){
				if(x[i]==y[i]){
					int c = 0;
					z[c] = x[i];
				}
			}
		}

	}

}
