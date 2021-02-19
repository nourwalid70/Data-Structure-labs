
public class Calculator implements ICalculator {
	  @Override
		public int add (int x , int y) { 
			return x+y;
		}
		  @Override
		public float divide(int x, int y) throws RuntimeException{
			if(y==0) {
			throw new RuntimeException(" YOU can't divide by Zero ! ");
			}
			else if (x==0) {
				return 0.0f;
			}
			else {
			return (float)x/y;}
		}
	}

