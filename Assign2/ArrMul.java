import mpi.MPI;

class ArrMul {
	public static void main(String[] args)
	{
		MPI.Init(args);

		int currentRank = MPI.COMM_WORLD.Rank();
		int totalProcess = MPI.COMM_WORLD.Size();

		int processArrSize = 5;
		double completeArr[] = new double[processArrSize * totalProcess];
		double receiveArr[] = new double[processArrSize];
		double reducedArr[] = new double[totalProcess];

		if(currentRank == 0) {
			for(int i=0; i<completeArr.length; i++) {
				System.out.println("Arr " + i + " : " + (i + 1));
				completeArr[i] = i + 1;
			}
		}

        MPI.COMM_WORLD.Scatter(completeArr, 0, processArrSize, MPI.DOUBLE, receiveArr, 0, processArrSize, MPI.DOUBLE, 0);

        for(int i=1; i<processArrSize; i++)
            receiveArr[0] *= receiveArr[i];

        MPI.COMM_WORLD.Gather(receiveArr, 0, 1, MPI.DOUBLE, reducedArr, 0, 1, MPI.DOUBLE, 0);

        if(currentRank == 0) {
			System.out.print("Reduced: ");
            for(int i=0; i<totalProcess; i++)
                System.out.print(reducedArr[i] + " ");
            System.out.println();

            for(int i=1; i<totalProcess; i++)
                reducedArr[0] *= reducedArr[i];

            System.out.println(reducedArr[0]);
        }

        MPI.Finalize();
	}
}
