using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using SMSAPI.Models;

namespace USSDAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class USSDCallbackController : ControllerBase
    {
        [HttpPost]
        [Route("[action]")]
        public async Task<ActionResult<USSDCallback>> USSDCallback(USSDCallback uSSDCallback)
        {
            //_context.uSSDCallback.Add(uSSDCallback);
            //await _context.SaveChangesAsync();
            if (uSSDCallback.command.ToUpper() == "INITIATE")
            {
                uSSDCallback.payload.request_id = "0";
                uSSDCallback.payload.response = "enter phone number";
            }
            else if (uSSDCallback.command.ToUpper() == "CONTINUE")
            {
                uSSDCallback.payload.request_id = "1";
                uSSDCallback.payload.response = "enter amount";
            }
            else if (uSSDCallback.command.ToUpper() == "TERMINATE")
            {
                uSSDCallback.payload.request_id = "2";
                uSSDCallback.payload.response = "press 1 to end session";
            }

            //if (uSSDCallback.command == "terminate")
            //    return new OkObjectResult("Request is termintating soon");
            //else if (uSSDCallback.command == "continue")
            //    return new OkObjectResult("On Progress");
            //else
            //    return new OkObjectResult(" ");
            return new OkObjectResult(uSSDCallback);
        }
    }
}
