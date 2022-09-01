<?php

$data = file_get_contents('php://input');
$data = json_decode($data, true);

$msisdn = $data['msisdn'];
$command = $data['command'];
$session_id = $data['session_id'];
$operator = $data['operator'];
$payload = $data['payload'];
$request_id = $payload['request_id'];
$response = $payload['response'];

$ussd_menu = array("phone" => "enter phone number", "amount" => "enter amount");
$request = (array_values($ussd_menu)[$request_id]);

$command = $request_id + 1 === count($ussd_menu) ? "terminate" : "continue";

if ($command === "terminate") {
    echo "Request is termintating soon <br/>";
}
if ($command === "continue") {
    echo "On Progress <br/>";
}

$res = array(
    'command' => $command,
    'msisdn' => $msisdn,
    'session_id' => $session_id,
    'operator' => $operator,
    'payload' => array(
        'request_id' => $request_id,
        'request' => $request,
    ),
);

$json = json_encode($res);
echo $json;
?>
