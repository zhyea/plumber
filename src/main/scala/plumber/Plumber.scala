package plumber

import io.vertx.core.{DeploymentOptions, Vertx}

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

    vertx.deployVerticle(classOf[ServerVerticle].getName, options)

    println("Plumber server has been started!")
  }
}
