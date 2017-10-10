package jvm;

/**
 * -XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB -XX:+PrintGCDetails
 */
public class T02 {

	public static void main(String[] args) {
		byte[] b = new byte[1024];
	}
}
