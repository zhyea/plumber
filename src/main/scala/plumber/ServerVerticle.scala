package plumber

import io.vertx.core.net.{NetServer, NetServerOptions}
import io.vertx.core.{AbstractVerticle, Promise}
import plumber.handler.SocketHandler

/**
 * Server
 *
 * @author robin
 */
class ServerVerticle extends AbstractVerticle {


  private var server: NetServer = _

  private val socketHandler: SocketHandler = new SocketHandler()

  override def start(promise: Promise[Void]): Unit = {

    val option: NetServerOptions = new NetServerOptions().setPort(8190)

    server = vertx.createNetServer(option)
      .connectHandler(socketHandler)

    server.listen(8190)
  }


}
