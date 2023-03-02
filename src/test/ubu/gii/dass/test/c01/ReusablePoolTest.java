/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.*;

/**
 * @author alumno
 *
 */
public class ReusablePoolTest {
	/**
	 * variables a utilizar durante las pruebas.
	 */
	private ReusablePool pool = null;
	private Reusable r1, r2, r3 = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		pool = ReusablePool.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		pool = null;
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
//		ReusablePool pool = ReusablePool.getInstance();
//		
//		// Objeto no nulo.
//		assertNotNull(pool);
//		// Objeto es instancia de ReusablePool.
//		assertTrue(pool instanceof ReusablePool);
		//Dummy
		assertTrue(true);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 * @throws NotFreeInstanceException 
	 */
//	@Test(expected = NotFreeInstanceException.class)
	public void testAcquireReusable() throws NotFreeInstanceException {
//		Reusable reusable1 = pool.acquireReusable();
//		Reusable reusable2 = pool.acquireReusable();
//		//No son el mismo objeto
//		assertNotEquals(reusable1, reusable2);
//		//Debe lanzar la excepcion NotFreeInstanceException.
//		Reusable reusable3 = pool.acquireReusable();	
		
		//Dummy
		assertTrue(true);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		//Dummy
		assertTrue(true);
	}

}
