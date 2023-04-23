
package com.viruswar.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.viruswar.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ChangeMovesPermitFlags_QNAME = new QName("http://communication.server.viruswar.com/", "changeMovesPermitFlags");
    private final static QName _ChangeMovesPermitFlagsResponse_QNAME = new QName("http://communication.server.viruswar.com/", "changeMovesPermitFlagsResponse");
    private final static QName _CheckGameEnded_QNAME = new QName("http://communication.server.viruswar.com/", "checkGameEnded");
    private final static QName _CheckGameEndedResponse_QNAME = new QName("http://communication.server.viruswar.com/", "checkGameEndedResponse");
    private final static QName _FindWhoseTurn_QNAME = new QName("http://communication.server.viruswar.com/", "findWhoseTurn");
    private final static QName _FindWhoseTurnResponse_QNAME = new QName("http://communication.server.viruswar.com/", "findWhoseTurnResponse");
    private final static QName _GetClientGroup_QNAME = new QName("http://communication.server.viruswar.com/", "getClientGroup");
    private final static QName _GetClientGroupResponse_QNAME = new QName("http://communication.server.viruswar.com/", "getClientGroupResponse");
    private final static QName _GetMadeGameMoves_QNAME = new QName("http://communication.server.viruswar.com/", "getMadeGameMoves");
    private final static QName _GetMadeGameMovesResponse_QNAME = new QName("http://communication.server.viruswar.com/", "getMadeGameMovesResponse");
    private final static QName _HandleCrossMoves_QNAME = new QName("http://communication.server.viruswar.com/", "handleCrossMoves");
    private final static QName _HandleCrossMovesResponse_QNAME = new QName("http://communication.server.viruswar.com/", "handleCrossMovesResponse");
    private final static QName _HandlerOfClient_QNAME = new QName("http://communication.server.viruswar.com/", "handlerOfClient");
    private final static QName _HandlerOfClientResponse_QNAME = new QName("http://communication.server.viruswar.com/", "handlerOfClientResponse");
    private final static QName _IsMovePermit_QNAME = new QName("http://communication.server.viruswar.com/", "isMovePermit");
    private final static QName _IsMovePermitResponse_QNAME = new QName("http://communication.server.viruswar.com/", "isMovePermitResponse");
    private final static QName _Run_QNAME = new QName("http://communication.server.viruswar.com/", "run");
    private final static QName _RunResponse_QNAME = new QName("http://communication.server.viruswar.com/", "runResponse");
    private final static QName _SendCommand_QNAME = new QName("http://communication.server.viruswar.com/", "sendCommand");
    private final static QName _SendCommandResponse_QNAME = new QName("http://communication.server.viruswar.com/", "sendCommandResponse");
    private final static QName _SendCommandToCross_QNAME = new QName("http://communication.server.viruswar.com/", "sendCommandToCross");
    private final static QName _SendCommandToCrossResponse_QNAME = new QName("http://communication.server.viruswar.com/", "sendCommandToCrossResponse");
    private final static QName _SendCommandToRound_QNAME = new QName("http://communication.server.viruswar.com/", "sendCommandToRound");
    private final static QName _SendCommandToRoundResponse_QNAME = new QName("http://communication.server.viruswar.com/", "sendCommandToRoundResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.viruswar.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChangeMovesPermitFlags }
     * 
     */
    public ChangeMovesPermitFlags createChangeMovesPermitFlags() {
        return new ChangeMovesPermitFlags();
    }

    /**
     * Create an instance of {@link ChangeMovesPermitFlagsResponse }
     * 
     */
    public ChangeMovesPermitFlagsResponse createChangeMovesPermitFlagsResponse() {
        return new ChangeMovesPermitFlagsResponse();
    }

    /**
     * Create an instance of {@link CheckGameEnded }
     * 
     */
    public CheckGameEnded createCheckGameEnded() {
        return new CheckGameEnded();
    }

    /**
     * Create an instance of {@link CheckGameEndedResponse }
     * 
     */
    public CheckGameEndedResponse createCheckGameEndedResponse() {
        return new CheckGameEndedResponse();
    }

    /**
     * Create an instance of {@link FindWhoseTurn }
     * 
     */
    public FindWhoseTurn createFindWhoseTurn() {
        return new FindWhoseTurn();
    }

    /**
     * Create an instance of {@link FindWhoseTurnResponse }
     * 
     */
    public FindWhoseTurnResponse createFindWhoseTurnResponse() {
        return new FindWhoseTurnResponse();
    }

    /**
     * Create an instance of {@link GetClientGroup }
     * 
     */
    public GetClientGroup createGetClientGroup() {
        return new GetClientGroup();
    }

    /**
     * Create an instance of {@link GetClientGroupResponse }
     * 
     */
    public GetClientGroupResponse createGetClientGroupResponse() {
        return new GetClientGroupResponse();
    }

    /**
     * Create an instance of {@link GetMadeGameMoves }
     * 
     */
    public GetMadeGameMoves createGetMadeGameMoves() {
        return new GetMadeGameMoves();
    }

    /**
     * Create an instance of {@link GetMadeGameMovesResponse }
     * 
     */
    public GetMadeGameMovesResponse createGetMadeGameMovesResponse() {
        return new GetMadeGameMovesResponse();
    }

    /**
     * Create an instance of {@link HandleCrossMoves }
     * 
     */
    public HandleCrossMoves createHandleCrossMoves() {
        return new HandleCrossMoves();
    }

    /**
     * Create an instance of {@link HandleCrossMovesResponse }
     * 
     */
    public HandleCrossMovesResponse createHandleCrossMovesResponse() {
        return new HandleCrossMovesResponse();
    }

    /**
     * Create an instance of {@link HandlerOfClient }
     * 
     */
    public HandlerOfClient createHandlerOfClient() {
        return new HandlerOfClient();
    }

    /**
     * Create an instance of {@link HandlerOfClientResponse }
     * 
     */
    public HandlerOfClientResponse createHandlerOfClientResponse() {
        return new HandlerOfClientResponse();
    }

    /**
     * Create an instance of {@link IsMovePermit }
     * 
     */
    public IsMovePermit createIsMovePermit() {
        return new IsMovePermit();
    }

    /**
     * Create an instance of {@link IsMovePermitResponse }
     * 
     */
    public IsMovePermitResponse createIsMovePermitResponse() {
        return new IsMovePermitResponse();
    }

    /**
     * Create an instance of {@link Run }
     * 
     */
    public Run createRun() {
        return new Run();
    }

    /**
     * Create an instance of {@link RunResponse }
     * 
     */
    public RunResponse createRunResponse() {
        return new RunResponse();
    }

    /**
     * Create an instance of {@link SendCommand }
     * 
     */
    public SendCommand createSendCommand() {
        return new SendCommand();
    }

    /**
     * Create an instance of {@link SendCommandResponse }
     * 
     */
    public SendCommandResponse createSendCommandResponse() {
        return new SendCommandResponse();
    }

    /**
     * Create an instance of {@link SendCommandToCross }
     * 
     */
    public SendCommandToCross createSendCommandToCross() {
        return new SendCommandToCross();
    }

    /**
     * Create an instance of {@link SendCommandToCrossResponse }
     * 
     */
    public SendCommandToCrossResponse createSendCommandToCrossResponse() {
        return new SendCommandToCrossResponse();
    }

    /**
     * Create an instance of {@link SendCommandToRound }
     * 
     */
    public SendCommandToRound createSendCommandToRound() {
        return new SendCommandToRound();
    }

    /**
     * Create an instance of {@link SendCommandToRoundResponse }
     * 
     */
    public SendCommandToRoundResponse createSendCommandToRoundResponse() {
        return new SendCommandToRoundResponse();
    }

    /**
     * Create an instance of {@link ServerResponseDto }
     * 
     */
    public ServerResponseDto createServerResponseDto() {
        return new ServerResponseDto();
    }

    /**
     * Create an instance of {@link MadeCommandsDto }
     * 
     */
    public MadeCommandsDto createMadeCommandsDto() {
        return new MadeCommandsDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeMovesPermitFlags }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangeMovesPermitFlags }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "changeMovesPermitFlags")
    public JAXBElement<ChangeMovesPermitFlags> createChangeMovesPermitFlags(ChangeMovesPermitFlags value) {
        return new JAXBElement<ChangeMovesPermitFlags>(_ChangeMovesPermitFlags_QNAME, ChangeMovesPermitFlags.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeMovesPermitFlagsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangeMovesPermitFlagsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "changeMovesPermitFlagsResponse")
    public JAXBElement<ChangeMovesPermitFlagsResponse> createChangeMovesPermitFlagsResponse(ChangeMovesPermitFlagsResponse value) {
        return new JAXBElement<ChangeMovesPermitFlagsResponse>(_ChangeMovesPermitFlagsResponse_QNAME, ChangeMovesPermitFlagsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckGameEnded }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckGameEnded }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "checkGameEnded")
    public JAXBElement<CheckGameEnded> createCheckGameEnded(CheckGameEnded value) {
        return new JAXBElement<CheckGameEnded>(_CheckGameEnded_QNAME, CheckGameEnded.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckGameEndedResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckGameEndedResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "checkGameEndedResponse")
    public JAXBElement<CheckGameEndedResponse> createCheckGameEndedResponse(CheckGameEndedResponse value) {
        return new JAXBElement<CheckGameEndedResponse>(_CheckGameEndedResponse_QNAME, CheckGameEndedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindWhoseTurn }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindWhoseTurn }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "findWhoseTurn")
    public JAXBElement<FindWhoseTurn> createFindWhoseTurn(FindWhoseTurn value) {
        return new JAXBElement<FindWhoseTurn>(_FindWhoseTurn_QNAME, FindWhoseTurn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindWhoseTurnResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindWhoseTurnResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "findWhoseTurnResponse")
    public JAXBElement<FindWhoseTurnResponse> createFindWhoseTurnResponse(FindWhoseTurnResponse value) {
        return new JAXBElement<FindWhoseTurnResponse>(_FindWhoseTurnResponse_QNAME, FindWhoseTurnResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientGroup }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetClientGroup }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "getClientGroup")
    public JAXBElement<GetClientGroup> createGetClientGroup(GetClientGroup value) {
        return new JAXBElement<GetClientGroup>(_GetClientGroup_QNAME, GetClientGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientGroupResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetClientGroupResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "getClientGroupResponse")
    public JAXBElement<GetClientGroupResponse> createGetClientGroupResponse(GetClientGroupResponse value) {
        return new JAXBElement<GetClientGroupResponse>(_GetClientGroupResponse_QNAME, GetClientGroupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMadeGameMoves }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMadeGameMoves }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "getMadeGameMoves")
    public JAXBElement<GetMadeGameMoves> createGetMadeGameMoves(GetMadeGameMoves value) {
        return new JAXBElement<GetMadeGameMoves>(_GetMadeGameMoves_QNAME, GetMadeGameMoves.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMadeGameMovesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMadeGameMovesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "getMadeGameMovesResponse")
    public JAXBElement<GetMadeGameMovesResponse> createGetMadeGameMovesResponse(GetMadeGameMovesResponse value) {
        return new JAXBElement<GetMadeGameMovesResponse>(_GetMadeGameMovesResponse_QNAME, GetMadeGameMovesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HandleCrossMoves }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HandleCrossMoves }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "handleCrossMoves")
    public JAXBElement<HandleCrossMoves> createHandleCrossMoves(HandleCrossMoves value) {
        return new JAXBElement<HandleCrossMoves>(_HandleCrossMoves_QNAME, HandleCrossMoves.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HandleCrossMovesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HandleCrossMovesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "handleCrossMovesResponse")
    public JAXBElement<HandleCrossMovesResponse> createHandleCrossMovesResponse(HandleCrossMovesResponse value) {
        return new JAXBElement<HandleCrossMovesResponse>(_HandleCrossMovesResponse_QNAME, HandleCrossMovesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HandlerOfClient }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HandlerOfClient }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "handlerOfClient")
    public JAXBElement<HandlerOfClient> createHandlerOfClient(HandlerOfClient value) {
        return new JAXBElement<HandlerOfClient>(_HandlerOfClient_QNAME, HandlerOfClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HandlerOfClientResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HandlerOfClientResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "handlerOfClientResponse")
    public JAXBElement<HandlerOfClientResponse> createHandlerOfClientResponse(HandlerOfClientResponse value) {
        return new JAXBElement<HandlerOfClientResponse>(_HandlerOfClientResponse_QNAME, HandlerOfClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsMovePermit }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IsMovePermit }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "isMovePermit")
    public JAXBElement<IsMovePermit> createIsMovePermit(IsMovePermit value) {
        return new JAXBElement<IsMovePermit>(_IsMovePermit_QNAME, IsMovePermit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsMovePermitResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IsMovePermitResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "isMovePermitResponse")
    public JAXBElement<IsMovePermitResponse> createIsMovePermitResponse(IsMovePermitResponse value) {
        return new JAXBElement<IsMovePermitResponse>(_IsMovePermitResponse_QNAME, IsMovePermitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Run }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Run }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "run")
    public JAXBElement<Run> createRun(Run value) {
        return new JAXBElement<Run>(_Run_QNAME, Run.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RunResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "runResponse")
    public JAXBElement<RunResponse> createRunResponse(RunResponse value) {
        return new JAXBElement<RunResponse>(_RunResponse_QNAME, RunResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendCommand }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendCommand }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "sendCommand")
    public JAXBElement<SendCommand> createSendCommand(SendCommand value) {
        return new JAXBElement<SendCommand>(_SendCommand_QNAME, SendCommand.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendCommandResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendCommandResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "sendCommandResponse")
    public JAXBElement<SendCommandResponse> createSendCommandResponse(SendCommandResponse value) {
        return new JAXBElement<SendCommandResponse>(_SendCommandResponse_QNAME, SendCommandResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendCommandToCross }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendCommandToCross }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "sendCommandToCross")
    public JAXBElement<SendCommandToCross> createSendCommandToCross(SendCommandToCross value) {
        return new JAXBElement<SendCommandToCross>(_SendCommandToCross_QNAME, SendCommandToCross.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendCommandToCrossResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendCommandToCrossResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "sendCommandToCrossResponse")
    public JAXBElement<SendCommandToCrossResponse> createSendCommandToCrossResponse(SendCommandToCrossResponse value) {
        return new JAXBElement<SendCommandToCrossResponse>(_SendCommandToCrossResponse_QNAME, SendCommandToCrossResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendCommandToRound }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendCommandToRound }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "sendCommandToRound")
    public JAXBElement<SendCommandToRound> createSendCommandToRound(SendCommandToRound value) {
        return new JAXBElement<SendCommandToRound>(_SendCommandToRound_QNAME, SendCommandToRound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendCommandToRoundResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendCommandToRoundResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://communication.server.viruswar.com/", name = "sendCommandToRoundResponse")
    public JAXBElement<SendCommandToRoundResponse> createSendCommandToRoundResponse(SendCommandToRoundResponse value) {
        return new JAXBElement<SendCommandToRoundResponse>(_SendCommandToRoundResponse_QNAME, SendCommandToRoundResponse.class, null, value);
    }

}