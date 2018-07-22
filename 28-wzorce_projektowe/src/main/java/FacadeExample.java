/* Complex parts */

class CPU {
	public void freeze(){}
	public void jump(long position) {}
	public void execute() {}
}

class HardDrive {
	public void read(long lba, int size) {}
}

class Memory {
	public void load(long position, int data) {}
}

/* Facade */

class ComputerFacade {
	private CPU processor;
	private Memory ram;
	private HardDrive hd;
	private long BOOT_ADDRESS;
	private long BOOT_SECTOR;
	private int SECTOR_SIZE;
	private int DATA_CONTENT;

	public ComputerFacade() {
		this.processor = new CPU();
		this.ram = new Memory();
		this.hd = new HardDrive();
	}

	public void start() {
		processor.freeze();
		ram.load(BOOT_ADDRESS, DATA_CONTENT);
		hd.read(BOOT_SECTOR, SECTOR_SIZE);
		processor.jump(BOOT_ADDRESS);
		processor.execute();
	}
}

/* Client */

class FacadeExample {
	public static void main(String[] args) {
		ComputerFacade computer = new ComputerFacade();
		computer.start();
	}
}