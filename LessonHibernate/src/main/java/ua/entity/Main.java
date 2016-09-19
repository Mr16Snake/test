package ua.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

import ua.dao.BrandDao;
import ua.dao.CategoryDao;
import ua.dao.ItemDao;
import ua.dao.ScreenDao;
import ua.dao.implementation.BrandDaoImpl;
import ua.dao.implementation.CategoryDaoImpl;
import ua.dao.implementation.ItemDaoImpl;
import ua.dao.implementation.ScreenDaoImpl;

public class Main {
	
	static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	static EntityManager em = factory.createEntityManager();
	
	private final static Scanner SC = new Scanner(System.in);
	
	private static final CategoryDao CATEGORY_DAO = new CategoryDaoImpl(em);
	private static final ItemDao ITEM_DAO = new ItemDaoImpl(em);
	private static final BrandDao BRAND_DAO = new BrandDaoImpl(em);
	private static final ScreenDao SCREEN_DAO = new ScreenDaoImpl(em);

	public static void main(String[] args) {
		
//		em.getTransaction().begin();
		
		boolean isRun = true;
		while(isRun){
			System.out.println("Enter 1 to add budget category to DB");
			System.out.println("Enter 2 to add smartphone to DB");
			System.out.println("Enter 3 to add brand to DB");
			System.out.println("Enter 4 to add screen size to DB");
			System.out.println("Enter 5 to remove smartphone from DB");
			System.out.println("Enter 0 to exit");
			switch (SC.next()){
			case "1":{
				Budget budget = new Budget();
				System.out.print("Enter new budget value: ");
				budget.setValue(SC.next());
				CATEGORY_DAO.save(budget);
				break;
			}
			case "2":{
				if(!em.getTransaction().isActive())em.getTransaction().begin();
				Smartphone smart = new Smartphone();
				BRAND_DAO.findAll().forEach(System.out::println);
				System.out.print("Enter brand number: ");
				Brand brand = BRAND_DAO.findOne(SC.nextInt());
				smart.setBrand(brand);
				System.out.print("Enter model: ");
				smart.setModel(SC.next());
				CATEGORY_DAO.findAll().forEach(System.out::println);
				System.out.print("Enter budget number: ");
				Budget budget = CATEGORY_DAO.findOne(SC.nextInt());
				smart.setBudget(budget);
				SCREEN_DAO.findAll().forEach(System.out::println);
				System.out.print("Enter number of screen size: ");
				ScreenSize screen = SCREEN_DAO.findOne(SC.nextInt());
				smart.setScreenSize(screen);
				System.out.print("Enter if main camera is good (y/n): ");
				String eq = SC.next();
				if(eq.equals("y"))smart.setMainCamera(true);
				else if (eq.equals("n"))smart.setMainCamera(false);
				System.out.print("Enter if front camera is good (y/n): ");
				eq = SC.next();
				if(eq.equals("y"))smart.setFrontCamera(true);
				else if (eq.equals("n"))smart.setFrontCamera(false);
				System.out.print("Enter if processor is powerfull (y/n): ");
				eq = SC.next();
				if(eq.equals("y"))smart.setPowerful(true);
				else if (eq.equals("n"))smart.setPowerful(false);
				System.out.print("Enter if battery is good (y/n): ");
				eq = SC.next();
				if(eq.equals("y"))smart.setBatteryGood(true);
				else if (eq.equals("n"))smart.setBatteryGood(false);
				System.out.print("Enter material (1-other, 2-metal, 3-glass): ");
				switch(SC.next()){
				case "1":{
					smart.setMaterial(Material.OTHER);
				}
				case "2":{
					smart.setMaterial(Material.METAL);
				}
				case "3":{
					smart.setMaterial(Material.GLASS);
				}
				}
				ITEM_DAO.save(smart);
				break;
			}
			case "3":{
				Brand brand = new Brand();
				System.out.print("Enter new brand: ");
				brand.setName(SC.next());
				BRAND_DAO.save(brand);
				break;
			}
			case "4":{
				ScreenSize screen = new ScreenSize();
				System.out.print("Enter new screen size: ");
				screen.setValue(SC.next());
				SCREEN_DAO.save(screen);
				break;
			}
			case "5":{
				if(!em.getTransaction().isActive())em.getTransaction().begin();
				System.out.print("Enter smartphone model which you want to remove: ");
				String name = SC.next();
				Smartphone smart = em.createQuery("SELECT s FROM Smartphone s WHERE"
						+ " s.model=:name", Smartphone.class)
						.setParameter("name", name)
						.getSingleResult();
				ITEM_DAO.delete(smart);
				break;
			}
			default:{
				isRun = false;
			}
			}
		}
		
//		Brand brand1 = new Brand();
//		brand1.setName("Xiaomi");
//		em.persist(brand1);
//		Brand brand2 = new Brand();
//		brand2.setName("Meizu");
//		em.persist(brand2);
//		Brand brand3 = new Brand();
//		brand3.setName("Samsung");
//		em.persist(brand3);
//		Brand brand4 = new Brand();
//		brand4.setName("LG");
//		em.persist(brand4);
//		Brand brand5 = new Brand();
//		brand5.setName("Huawei");
//		em.persist(brand5);
//		Brand brand6 = new Brand();
//		brand6.setName("HTC");
//		em.persist(brand6);
//		Brand brand7 = new Brand();
//		brand7.setName("Sony");
//		em.persist(brand7);
//		Brand brand8 = new Brand();
//		brand8.setName("Ulefone");
//		em.persist(brand8);
		
//	    Brand brand = em.find(Brand.class, 1);                     //  - пошук по айдішці
//		Brand brand = em.createQuery("SELECT c FROM Brand c WHERE" //  - пошук по нейму
//				+ " c.name=:name", Brand.class)
//				.setParameter("name", "Xiaomi")
//				.getSingleResult();
//		Smartphone smart = new Smartphone();
//		smart.setBrand(brand);
//		smart.setModel("Mi Max");
//		em.persist(smart);
		
//		Smartphone smart = em.createQuery("SELECT c FROM Smartphone c WHERE"
//				+ " c.model=:name", Smartphone.class)
//				.setParameter("name", "Mi Max")
//				.getSingleResult();
//		smart.setMaterial(Material.OTHER);
//		em.createQuery("SELECT c FROM Smartphone c WHERE"
//				+ " c.model=:model", Smartphone.class)
//				.setParameter("model", "Mi Max")
//				.getSingleResult().setMaterial(Material.METAL);
		
//		Brand brand = em.createQuery("SELECT c FROM Brand c JOIN "
//				+ "c.smartphones r WHERE r.model=:name", Brand.class)
//				.setParameter("name", "Mi Max")
//				.getSingleResult();
//		System.out.println(brand.getName());
		
//		List<Brand> brands = em.createQuery("SELECT c FROM "
//				+ "Brand c WHERE c.id in (:id)", Brand.class)
//				.setParameter("ids", Arrays.asList(1,2,3,4,5)) //множинний вибір для пошуку
//				.getResultList();
//		for (Brand brand : brands) {
//			System.out.println(brand.getId()+" "+brand.getName());
//		}
		
//		List<Brand> brands = em.createQuery("SELECT c FROM "
//				+ "Brand c order by c.name asc", Brand.class);//desc
		
//		SELECT r FROM Smartphone r WHERE r.brand.name like :like          //гавнокод
//		SELECT r FROM Smartphone r JOIN r.brand c WHERE c.name like :like //гуд
		
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Smartphone> cq = cb.createQuery(Smartphone.class);
//		Root<Smartphone> root = cq.from(Smartphone.class);
//		cq.select(root);
//		Predicate eq = cb.equal(root.get("model"), "Mi_Max");       //загальний пошук
//		Predicate in = root.get("id").in(Arrays.asList(1,2,3));     //пошук по заданому масиву
//		Expression<Integer> exp = root.get("id");                   //вираз
//		Predicate be = cb.between(exp, 1, 3);                       //використання виразу і пошук поміж айді 1 і 10
//		
//		Join<Smartphone, Brand> brandJoin = root.join("brand"); //в стрінгу поле зі смартфону
//		Expression<Integer> expl = brandJoin.get("name");       //в стрінгу поле з бренду
//		Predicate amPred = cb.equal(expl, "Xiaomi");            //пошук по конкретному бренду
//		Join<Smartphone, ScreenSize> msJoin = root.join("screenSize");
//		Predicate msPred = cb.equal(msJoin.get("value"), "5.9<");//шукає цей розмір екрану тільки з попередньо знайденого бренду
//		Predicate and = cb.and(amPred, msPred);
//		cq.where(and, eq, in, be);                               //шукає спільне серед усіх тих предікейтів
//		List<Smartphone> smarts = em.createQuery(cq).getResultList();
//		smarts.forEach(System.out::println);
		
		if(em.getTransaction().isActive())em.getTransaction().commit();		
		em.close();
		factory.close();
	}

}
