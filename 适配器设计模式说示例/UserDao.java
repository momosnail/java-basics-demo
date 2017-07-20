package cn.itcast_03;

/*
 * 针对用户操作的四种功能
 */
public interface UserDao {
	public abstract void add();

	public abstract void delete();

	public abstract void update();

	public abstract void find();
}
