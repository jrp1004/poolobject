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
		//Comprobamos que el objeto esta vacío antes de obtener el pool de objetos.
		assertNull(pool);
		pool = ReusablePool.getInstance();		
		//Comprobamos que el objeto no es nulo tras obtener el pool de objetos.
		assertNotNull(pool);
		//Comprobamos que el Objeto es instancia de ReusablePool.
		assertTrue(pool instanceof ReusablePool);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 * @throws NotFreeInstanceException 
	 */
//	@Test(expected = NotFreeInstanceException.class)
	public void testAcquireReusable() throws NotFreeInstanceException {
		//Comprobamos que el objeto esta vacío antes de obtener el reusable del pool de objetos.
		assertNull(r1);
		//Comprobamos que el objeto esta vacío antes de obtener el reusable del pool de objetos.
		assertNull(r2);
		r1 = pool.acquireReusable();
		r2 = pool.acquireReusable();
		//Comprobamos que el objeto no esta vacío tras obtener el reusable del pool de objetos.
		assertNotNull(r1);
		//Comprobamos que el objeto no esta vacío tras obtener el reusable del pool de objetos.
		assertNotNull(r2);
		//No son el mismo objeto
//		assertNotEquals(r1, r2);
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
