
  window.watsonAssistantChatOptions = {
    integrationID: "aa8da97d-2aa6-420b-aee4-64655ea741c6", // The ID of this integration.
    region: "us-south", // The region your integration is hosted in.
    serviceInstanceID: "a021c9d3-5b89-45ad-ac9d-7fa62e9d55bb", // The ID of your service instance.
    onLoad: async (instance) => { await instance.render(); }
  };
  setTimeout(function(){
    const t=document.createElement('script');
    t.src="https://web-chat.global.assistant.watson.appdomain.cloud/versions/" + (window.watsonAssistantChatOptions.clientVersion || 'latest') + "/WatsonAssistantChatEntry.js";
    document.head.appendChild(t);
  });
