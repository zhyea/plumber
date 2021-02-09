package plumber

import io.vertx.core.{AsyncResult, DeploymentOptions, Handler, Vertx}

/**
 * Plumber
 *
 * @author robin
 */
object Plumber {


	def main(args: Array[String]): Unit = {

		val options: DeploymentOptions =
			new DeploymentOptions()
				.setWorkerPoolName("plumber-pool")
				.setWorkerPoolSize(1)

		val vertx: Vertx = Vertx.vertx()

		vertx.deployVerticle(classOf[ServerVerticle].getName, options, new Handler[AsyncResult[String]] {
			override def handle(result: AsyncResult[String]): Unit = {
				if (result.succeeded) {
					System.out.println("Server is now listening!")
				} else {
					System.out.println("Failed to bind!")
				}
			}
		})

		println("Plumber server has been started!")
	}
}
