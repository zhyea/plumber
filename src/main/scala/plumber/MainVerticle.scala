package plumber

import io.vertx.core.net.{NetServer, NetServerOptions}
import io.vertx.core.{AbstractVerticle, Promise}

/**
 *
 * @author robin
 */
class MainVerticle extends AbstractVerticle {


  private var server: NetServer = _


  override def start(promise: Promise[Void]): Unit = {
    val options = new NetServerOptions().setPort(8190)
    server = vertx.createNetServer(options)
  }


}
