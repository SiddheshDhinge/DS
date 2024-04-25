import mpi.MPI;

public class ArrSum {
    public static void main(String[] args) {
        MPI.Init(args);

        int totalProcess = MPI.COMM_WORLD.Size();
        int currentRank = MPI.COMM_WORLD.Rank();

        int processArrSize = 5;
        int reducedArr[] = new int[totalProcess];
        int receiveArr[] = new int[processArrSize];
        int completeArr[] = new int[totalProcess * processArrSize];

        if(currentRank == 0)
        {
            for(int i=0; i<completeArr.length; i++)
            {
                System.out.println("arr " + i + " : " + (i + 1));
                completeArr[i] = i + 1;
            }
        }

        MPI.COMM_WORLD.Scatter(completeArr, 0, processArrSize, MPI.INT, receiveArr, 0, processArrSize, MPI.INT, 0);
        
        for(int i=1; i<receiveArr.length; i++)
        {
            receiveArr[0] += receiveArr[i];
        }

        MPI.COMM_WORLD.Gather(receiveArr, 0, 1, MPI.INT, reducedArr, 0, 1, MPI.INT, 0);

        if(currentRank == 0)
        {
            for(int i=0; i<reducedArr.length; i++)
                System.out.print(reducedArr[i] + " ");
            System.out.println();

            for(int i=1; i<reducedArr.length; i++)
                reducedArr[0] += reducedArr[i];

            System.out.println(reducedArr[0]);
        }

        MPI.Finalize();
    }
}
