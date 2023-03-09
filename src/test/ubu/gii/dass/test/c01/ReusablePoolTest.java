/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
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
		System.out.println("Setting it up!");
		pool = ReusablePool.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("Tearing it down!");
		pool = null;
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		ReusablePool pool = ReusablePool.getInstance();
		
		// Objeto no nulo.
		assertNotNull(pool);
		// Objeto es instancia de ReusablePool.
		assertTrue(pool instanceof ReusablePool);
		//Misma instancia
		assertEquals(this.pool,pool);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 * @throws NotFreeInstanceException 
	 */
	@Test
	public void testAcquireReusable() throws NotFreeInstanceException {
		System.out.println("Running: testAcquireReusable");
		//Comprobamos que el objeto no es nulo.
		assertNotNull(pool);
		//Comprobamos que el objeto esta vacio antes de obtener el reusable del pool de objetos.
		assertNull(r1);
		//Comprobamos que el objeto esta vacio antes de obtener el reusable del pool de objetos.
		assertNull(r2);
		r1 = pool.acquireReusable();
		r2 = pool.acquireReusable();
		//Comprobamos que el mensaje es correcto
		assertThat(r1.util(), CoreMatchers.containsString("Uso del objeto Reutilizable"));
		//Comprobamos que el objeto no esta vacio tras obtener el reusable del pool de objetos.
		assertNotNull(r1);
		//Comprobamos que el objeto no esta vacio tras obtener el reusable del pool de objetos.
		assertNotNull(r2);		
		//Comprobamos que el Objeto es instancia de Reusable.
		assertTrue(r1 instanceof Reusable);
		//Comprobamos que el Objeto es instancia de Reusable.
		assertTrue(r2 instanceof Reusable);
		//Comprobamos que no son el mismo objeto.		
		assertNotEquals(r1, r2);
		try {
			//Debe lanzar la excepcion NotFreeInstanceException.
			r3 = pool.acquireReusable();
			fail("no se lanzo la excepcion");			
		} catch (NotFreeInstanceException e) {
			//La excepcion capturada es ded tipo NotFreeInstanceException
			assertTrue(e instanceof NotFreeInstanceException);
		}
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 * @throws NotFreeInstanceException 
	 * @throws DuplicatedInstanceException 
	 */
	@Test
	public void testReleaseReusable() throws NotFreeInstanceException, DuplicatedInstanceException {
		System.out.println("Running: testReleaseReusable");
		//Comprobamos que el objeto no es nulo.
		assertNotNull(pool);
		//Comprobamos que el objeto esta vacio antes de obtener el reusable del pool de objetos.
		assertNull(r1);
		//Comprobamos que el objeto esta vacio antes de obtener el reusable del pool de objetos.
		assertNull(r2);
		r1 = pool.acquireReusable();
		r2 = pool.acquireReusable();
		//Comprobamos que el objeto no esta vacio tras obtener el reusable del pool de objetos.
		assertNotNull(r1);
		//Comprobamos que el objeto no esta vacio tras obtener el reusable del pool de objetos.
		assertNotNull(r2);		
		//Comprobamos que el Objeto es instancia de Reusable.
		assertTrue(r1 instanceof Reusable);
		//Comprobamos que el Objeto es instancia de Reusable.
		assertTrue(r2 instanceof Reusable);
		//Comprobamos que no son el mismo objeto.		
		assertNotEquals(r1, r2);
		//Devolvemos al pool r1
		pool.releaseReusable(r1);
		try {
			r3 = pool.acquireReusable();
			//Comprobamos que el Objeto es instancia de Reusable.
			assertTrue(r2 instanceof Reusable);
			//Comprobamos que no son el mismo objeto.		
			assertNotEquals(r1, r2);
		} catch (NotFreeInstanceException e) {
			fail("se lanzo la excepcion inesperadamente");
		}
		try {
			//devolvemos dos veces al pool
			pool.releaseReusable(r3);
			pool.releaseReusable(r3);
			fail("se devuelve dos veces al pool");
		} catch (DuplicatedInstanceException e) {
			//La excepcion capturada es de tipo DuplicatedInstanceException
			assertTrue(e instanceof DuplicatedInstanceException);
			// devolvemos r2
			pool.releaseReusable(r2);
		}
	}
}
