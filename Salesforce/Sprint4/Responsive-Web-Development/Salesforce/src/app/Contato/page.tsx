"use client"
import { useState } from "react";
import Link from "next/link";
import './contato.css';

const Contato = () => {
    const [formValues, setFormValues] = useState({
        nome: "",
        email: "",
        telefone: "",
        empresa: "",
        regiao: ""
    });
    const [showSuccessPopup, setShowSuccessPopup] = useState(false);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormValues({ ...formValues, [name]: value });
    };

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        try {
            const response = await fetch("http://localhost:8080/Formulario/formulario", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(formValues)
            });

            if (response.ok) {
                console.log("Dados enviados com sucesso!");
                setShowSuccessPopup(true);
                setFormValues({
                    nome: "",
                    email: "",
                    telefone: "",
                    empresa: "",
                    regiao: ""
                });
            } else {
                console.error("Erro ao enviar dados:", response.statusText);
            }
        } catch (error) {
            console.error("Erro ao enviar dados:");
        }
    };

    const handleClosePopup = () => {
        setShowSuccessPopup(false);
    };

    return (
        <>
            <div className="total-forms">
                <div className="form-text">
                    <h1 className="form-titulo">Como podemos ajudar você?</h1>
                    <p className="form-par">
                        Se tiver qualquer dúvida sobre nossos produtos, preços ou como começar a usar, estamos aqui para isso!
                        Nossos especialistas adorariam orientá-lo no caminho certo para o sucesso.
                    </p>
                    <p className="form-par">
                        Quer conversar? É só preencher o formulário aqui ao lado ou, se preferir, você pode ligar para
                        0800 891 1887!
                    </p>
                    <span className="form-par">Já é cliente? Visite o link abaixo:</span>
                    <Link className="form-link" href="./">Faturamento e Suporte Técnico</Link>
                </div>
                <div className="form-forms">
                    <form onSubmit={handleSubmit}>
                        <label className="form-pequeno">
                            <span>Nome</span>
                            <span className="asterisco">*</span>
                            <input type="text" name="nome" value={formValues.nome} onChange={handleChange} required />
                        </label>
                        <label className="form-pequeno">
                            <span>Email Corporativo</span>
                            <span className="asterisco">*</span>
                            <input type="email" name="email" value={formValues.email} onChange={handleChange} required />
                        </label>
                        <label className="form-pequeno">
                            <span>Telefone</span>
                            <span className="asterisco">*</span>
                            <input type="text" name="telefone" value={formValues.telefone} onChange={handleChange} required />
                        </label>
                        <label className="form-pequeno">
                            <span>Empresa</span>
                            <span className="asterisco">*</span>
                            <input type="text" name="empresa" value={formValues.empresa} onChange={handleChange} required />
                        </label>
                        <label className="form-pequeno">
                            <span>Pais/Região</span>
                            <span className="asterisco">*</span>
                            <input type="text" name="regiao" value={formValues.regiao} onChange={handleChange} required />
                        </label>
                        <label className="form-question">
                            <p>Perguntas/Comentários</p>
                            <input type="text" name="perguntas" />
                        </label>
                        <section className="corpobotao">
                            <button type="submit" className="textobotao">RECEBER CONTATO!</button>
                        </section>
                    </form>
                </div>
            </div>
            {showSuccessPopup && (
                <div className="success-popup">
                    <div className="success-popup-content">
                        <span className="close-popup" onClick={handleClosePopup}>&times;</span>
                        <p>Dados enviados com sucesso!</p>
                    </div>
                </div>
            )}
        </>
    );
};

export default Contato;
