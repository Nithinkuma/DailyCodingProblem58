import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        String[] strs = line.trim().split(" ");

        ArrayList<Integer> list = new ArrayList<>();
        for (String str : strs) {
            list.add(Integer.parseInt(str));
        }

        int target = Integer.parseInt(br.readLine());
        System.out.println(bubbleSortOnRotatedArray(list, target));
    }

    private static int bubbleSortOnRotatedArray(ArrayList<Integer> list, int target) {
        int start = 0;
        int end = list.size()-1;
        int l = list.get(start);
        int r = list.get(end);
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) == target){
                return mid;
            }

            else {
                if (list.get(mid) > r) {
                    if (target >= l && target < list.get(mid))
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
                else {
                    if (list.get(mid) > r) {
                        if (target <= r && target > list.get(mid))
                            start = mid + 1;
                        else
                            end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}