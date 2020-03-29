package pass;

public class BlockPass {
		static int i;

		public BlockPass(int i) {
			this.i = i;
		}
		
		static {
			i = i + 1;
		}		
		
		{
		
		}
		
		public int returnNumber() {
			return i;
		}
}
