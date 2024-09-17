"use client"
import { useState } from 'react';
import "../../../public/css/reciclagem.css";

interface UserForm {
    nome: string;
    email: string;
    cep: string;
}

interface CompanyForm {
    cnpj: string;
    nomeFant: string;
    email: string;
    cep: string;
}

const Reciclagem = () => {
    const [userForm, setUserForm] = useState<UserForm>({ nome: '', email: '', cep: '' });
    const [companyForm, setCompanyForm] = useState<CompanyForm>({ cnpj: '', nomeFant: '', email: '', cep: '' });
    const [userSuccessMessage, setUserSuccessMessage] = useState('');
    const [companySuccessMessage, setCompanySuccessMessage] = useState('');

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>, formType: string) => {
        const { name, value } = e.target;
        if (formType === 'user') {
            setUserForm({ ...userForm, [name]: value });
        } else {
            setCompanyForm({ ...companyForm, [name]: value });
        }
    };

    const validateForm = (formData: UserForm | CompanyForm) => {
        return Object.values(formData).every(value => value.trim() !== '');
    };

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>, formType: string) => {
        e.preventDefault();
        const url = formType === 'user' 
            ? 'http://localhost:8080/GlobalSolution/cadastropf' 
            : 'http://localhost:8080/GlobalSolution/cadastropj';
        const formData = formType === 'user' ? userForm : companyForm;

        if (!validateForm(formData)) {
            if (formType === 'user') {
                setUserSuccessMessage('Por favor, preencha todos os campos do formulário antes de realizar o envio.');
            } else {
                setCompanySuccessMessage('Por favor, preencha todos os campos do formulário antes de realizar o envio.');
            }
            return;
        }

        try {
            const response = await fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });

            if (response.ok) {
                if (formType === 'user') {
                    setUserSuccessMessage('Cadastro de usuário realizado com sucesso! Te enviaremos o link do nosso aplicativo!');
                    setUserForm({ nome: '', email: '', cep: '' });
                    setCompanySuccessMessage('');
                } else {
                    setCompanySuccessMessage('Cadastro de empresa realizado com sucesso! Entraremos em contato para que você seja uma empresa parceira!');
                    setCompanyForm({ cnpj: '', nomeFant: '', email: '', cep: '' });
                    setUserSuccessMessage('');
                }
            } else {
                if (formType === 'user') {
                    setUserSuccessMessage('Erro ao realizar o cadastro de usuário.');
                } else {
                    setCompanySuccessMessage('Erro ao realizar o cadastro de empresa.');
                }
            }
        } catch (error) {
            console.error('Erro:', error);
            if (formType === 'user') {
                setUserSuccessMessage('Erro ao realizar o cadastro de usuário.');
            } else {
                setCompanySuccessMessage('Erro ao realizar o cadastro de empresa.');
            }
        }
    };

    return (
        <div className="reciclagem-container">
            <div>
                <h2 className="titulo">Tem lixo aí e não sabe onde levar ou tem interesse em se juntar a nós?</h2>
                <span>Faça seu cadastro como usuário ou futuro parceiro!</span>
                <div className="cadastros">
                    <div className="pf">
                        <form onSubmit={(e) => handleSubmit(e, 'user')}>
                            <p>Cadastro de usuários</p>
                            <label htmlFor="nome">
                                <span>Nome: </span>
                                <input 
                                    type="text" 
                                    name="nome" 
                                    value={userForm.nome} 
                                    onChange={(e) => handleChange(e, 'user')} 
                                />
                            </label>
                            <label htmlFor="email">
                                <span>E-mail: </span>
                                <input 
                                    type="email" 
                                    name="email" 
                                    value={userForm.email} 
                                    onChange={(e) => handleChange(e, 'user')} 
                                />
                            </label>
                            <label htmlFor="cep">
                                <span>CEP: </span>
                                <input 
                                    type="text" 
                                    name="cep" 
                                    value={userForm.cep} 
                                    onChange={(e) => handleChange(e, 'user')} 
                                />
                            </label>
                            <div className="botao">
                                <button type="submit">Enviar!</button>
                            </div>
                        </form>
                        {userSuccessMessage && <div className="success-message">{userSuccessMessage}</div>}
                    </div>
                    <div className="pj">
                        <form onSubmit={(e) => handleSubmit(e, 'company')}>
                            <p>Cadastro de empresas</p>
                            <label htmlFor="cnpj">
                                <span>CNPJ: </span>
                                <input 
                                    type="text" 
                                    name="cnpj" 
                                    value={companyForm.cnpj} 
                                    onChange={(e) => handleChange(e, 'company')} 
                                />
                            </label>
                            <label htmlFor="nomeFant">
                                <span>Nome Fantasia: </span>
                                <input 
                                    type="text" 
                                    name="nomeFant" 
                                    value={companyForm.nomeFant} 
                                    onChange={(e) => handleChange(e, 'company')} 
                                />
                            </label>
                            <label htmlFor="email">
                                <span>E-mail: </span>
                                <input 
                                    type="email" 
                                    name="email" 
                                    value={companyForm.email} 
                                    onChange={(e) => handleChange(e, 'company')} 
                                />
                            </label>
                            <label htmlFor="cep">
                                <span>CEP: </span>
                                <input 
                                    type="text" 
                                    name="cep" 
                                    value={companyForm.cep} 
                                    onChange={(e) => handleChange(e, 'company')} 
                                />
                            </label>
                            <div className="botao">
                                <button type="submit">Enviar!</button>
                            </div>
                        </form>
                        {companySuccessMessage && <div className="success-message">{companySuccessMessage}</div>}
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Reciclagem;
