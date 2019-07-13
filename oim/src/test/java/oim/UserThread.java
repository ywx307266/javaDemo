package oim;

public class UserThread implements Runnable
{

	private Work	work;

	private int		index;

	public UserThread(Work work, int num) {
		super();
		this.work = work;
		this.index = num;
	}

	public void run()
	{
		if (index == 0)
		{
			work.dowork();
		}
		else if (index == 2)
		{
			work.print();
		}
		else
		{
			work.doClear();
		}
	}

}
