package Arrays;

/*
    Print all possible strings of length k that can be formed from a set of n characters
 */
public class FindAllKLengthStrings {

    public static void main(String[] args){
        FindAllKLengthStrings f = new FindAllKLengthStrings();
        char[] set = {'a','b','c','d'};
        int k = 2;
        f.findKLengthStrings(set,k);
    }

    private void findKLengthStrings(char[] set, int k) {
        int n = set.length;
        findKLengthStrings(set,"",n,k);
    }

    private void findKLengthStrings(char[] set, String prefix, int n, int k) {
        int count = 0;
        if (k==0){
            count++;
            System.out.println(prefix);
        }else {
            for (int i=0;i<n;i++){
                String new_prefix = prefix + set[i];
                findKLengthStrings(set,new_prefix,n,k-1);
            }
        }
    }

}
